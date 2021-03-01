package compulsory;

public class Source {
    private String name;
    private SourceType type;
    private int capacity;


    public Source(String name, SourceType type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SourceType getType() {
        return type;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", capacity=" + capacity +
                '}';
    }
}
