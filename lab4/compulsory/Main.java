package compulsory;

import optional.Algorithm;
import optional.Problem;
import optional.Solution;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        // partea de compulsory
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);

        var schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i))
                .toArray(School[]::new);

        List<Student> listOfStudents = new LinkedList<>(Arrays.asList(students));

        listOfStudents.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });

        for (var student : listOfStudents)
            System.out.print(student.getName() + " ");
        System.out.println();

        Set<School> setOfSchools = new TreeSet<>(Arrays.asList(schools));

        for (var school : setOfSchools)
            System.out.print(school.getName() + " ");
        System.out.println();

        Map<Student, List<School>> studentPreferences = new HashMap<>();
        Map<School, List<Student>> schoolPreferences = new TreeMap<>();

        studentPreferences.put(students[0], new ArrayList<>(Arrays.asList(schools)));
        studentPreferences.put(students[1], new ArrayList<>(Arrays.asList(schools)));
        studentPreferences.put(students[2], new ArrayList<>(Arrays.asList(schools[0], schools[1])));
        studentPreferences.put(students[3], new ArrayList<>(Arrays.asList(schools[0], schools[2])));

        schoolPreferences.put(schools[0], new ArrayList<>(Arrays.asList(students[3], students[0], students[1], students[2])));
        schoolPreferences.put(schools[1], new ArrayList<>(Arrays.asList(students[0], students[2], students[1])));
        schoolPreferences.put(schools[2], new ArrayList<>(Arrays.asList(students[0], students[1], students[3])));


        System.out.println("\nstudent preferences:");
        for (var entry : studentPreferences.entrySet()) {
            System.out.print(entry.getKey().getName() + ": (");
            for (var school : entry.getValue())
                System.out.print(school.getName() + ", ");
            System.out.println(")");
        }

        System.out.println("\nschool preferences:");
        for (var entry : schoolPreferences.entrySet()) {
            System.out.print(entry.getKey().getName() + ": (");
            for (var student : entry.getValue())
                System.out.print(student.getName() + ", ");
            System.out.println(")");
        }


        // partea de optional

        // printez toti studentii care prefera anumite scoli (date intr-o lista)
        List<School> target = Arrays.asList(schools[0], schools[2]);
        listOfStudents.stream()
                .filter(std -> studentPreferences.get(std).containsAll(target))
                .forEach(System.out::println);

        // printez toate scolile care prefera cel mai mult un anumit student
        Student top = students[0];
        setOfSchools.stream()
                .filter(school -> schoolPreferences.get(school).get(0).equals(top))
                .forEach(System.out::println);

        Problem problem = Problem.generateRandomProblem(4, 4);
        problem.print();

        Solution solution = Algorithm.solve(problem);
        solution.print();
    }
}
