package optional;

import compulsory.School;
import compulsory.Student;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Student, School> assignment = new HashMap<>();

    public void addAssignment(Student student, School school) {
        assignment.put(student, school);
    }

    public void print() {
        for(var entry:assignment.entrySet())
            System.out.println(entry.getKey() + " este asignat la " + entry.getValue());
    }
}
