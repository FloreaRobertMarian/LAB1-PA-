package locatii;

import java.util.HashMap;
import java.util.Map;

public abstract class Location implements Comparable<Location> {
    private String name;
    private Map<Location, Integer> cost = new HashMap<>();

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Location, Integer> getCost() {
        return cost;
    }

    public void setCost(Location node, int value) {
        cost.put(node, value);
    }

    @Override
    public int compareTo(Location other) {
        if (other == null)
            throw new NullPointerException();

        return this.name.compareTo(other.name);
    }

}
