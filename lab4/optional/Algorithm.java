package optional;

import compulsory.School;
import compulsory.Student;

import java.util.List;
import java.util.Map;

public class Algorithm {
    public static Solution solve(Problem problem) {
        Solution solution = new Solution();

        List<Student> students = problem.getStudents();
        List<School> schools = problem.getSchools();
        Map<Student, List<School>> stdPrefMap = problem.getStdPrefMap();
        Map<School, List<Student>> schoolPrefMap = problem.getSchoolPrefMap();

        // toate scolile ordoneaza studentii la fel
        List<Student> ranking = schoolPrefMap.get(schools.get(0));

        for(Student student : students) {
            boolean gasit = false;

            for(School school : stdPrefMap.get(student))
                if(school.getCapacity() > 0) {
                    solution.addAssignment(student, school);
                    school.setCapacity(school.getCapacity() - 1);
                    gasit = true;
                    break;
                }

            if(!gasit)
                System.out.println("Studentul " + student + " nu a putut fi repartizat la niciuna dintre scolile la care dorea");
        }

        return solution;
    }
}
