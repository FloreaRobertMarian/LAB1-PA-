package catalog;

import item.Item;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Item> items = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public void add(Item item) throws InvalidCatalogException {
        if (Files.exists(Path.of(item.getLocation())))
            items.add(item);
        else throw new InvalidCatalogException(new FileNotFoundException());
    }

    public Item findById(String id) {
        return items.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    public void list() {
        System.out.println("Itemele din catalog:");
        for (var item : items)
            System.out.println(item);
    }
}

