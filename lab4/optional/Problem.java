package optional;

import com.github.javafaker.Faker;
import compulsory.School;
import compulsory.Student;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Problem {
    private List<Student> students = new ArrayList<>();
    private List<School> schools = new ArrayList<>();
    private Map<Student, List<School>> stdPrefMap = new HashMap<>();
    private Map<School, List<Student>> schoolPrefMap = new HashMap<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    public Map<Student, List<School>> getStdPrefMap() {
        return stdPrefMap;
    }

    public void setStdPrefMap(Map<Student, List<School>> stdPrefMap) {
        this.stdPrefMap = stdPrefMap;
    }

    public Map<School, List<Student>> getSchoolPrefMap() {
        return schoolPrefMap;
    }

    public void setSchoolPrefMap(Map<School, List<Student>> schoolPrefMap) {
        this.schoolPrefMap = schoolPrefMap;
    }

    public static Problem generateRandomProblem(int nrStudenti, int nrScoli) {
        Problem problem = new Problem();
        Faker faker = new Faker();

        List<Student> students = new ArrayList<>();
        List<School> schools = new ArrayList<>();
        Map<Student, List<School>> stdPrefMap = new HashMap<>();
        Map<School, List<Student>> schoolPrefMap = new HashMap<>();

        for (int i = 0; i < nrStudenti; i++)
            students.add(new Student(faker.name().fullName()));

        // adaug scoli cu nr random de locuri
        for (int i = 0; i < nrScoli; i++)
            schools.add(new School(faker.university().name(), ThreadLocalRandom.current().nextInt(1, 5)));

        for (var student : students) {
            int nrScoliPreferate = ThreadLocalRandom.current().nextInt(1, nrScoli);

            // ordonez scolile random si iau primele cateva din ele drept preferinte
            Collections.shuffle(schools);
            stdPrefMap.put(student, schools.subList(0, nrScoliPreferate));
        }

        // toate scolile au aceeasi lista de preferinte
        for(var school:schools)
            schoolPrefMap.put(school, students);

        problem.setSchools(schools);
        problem.setStudents(students);
        problem.setSchoolPrefMap(schoolPrefMap);
        problem.setStdPrefMap(stdPrefMap);

        return problem;
    }

    public void print() {
        System.out.println("Students:");
        students.forEach(System.out::println);
        System.out.println("Schools");
        schools.forEach(System.out::println);

        System.out.println("Student preferences:");
        stdPrefMap.entrySet().forEach(System.out::println);

        System.out.println("School preferences:");
        schoolPrefMap.entrySet().forEach(System.out::println);
    }

}
