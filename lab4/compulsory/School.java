package compulsory;

import java.util.Objects;

public class School implements Comparable<School> {
    private String name;
    private int capacity;

    public School(String name) {
        this(name, 0);
    }

    public School(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // override-uiesc equals si hashCode pt HashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(name, school.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(School o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
