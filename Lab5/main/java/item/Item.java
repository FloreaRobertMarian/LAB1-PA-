package item;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Item implements Serializable {
    protected String id;
    protected String name;
    protected String location; //file name or Web page

    private Map<String, Object> tags = new HashMap<>();

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public abstract String toString();
}

