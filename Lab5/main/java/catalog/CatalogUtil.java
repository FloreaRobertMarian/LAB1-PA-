package catalog;

import item.Item;

import java.awt.*;
import java.io.*;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path)
            throws InvalidCatalogException {
        try (var objInputStream = new ObjectInputStream(new FileInputStream(path))) {
            return (Catalog) objInputStream.readObject();
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File " + path + " is missing!");
        } catch (IOException ioException) {
            System.err.println("Unexpected error reading file " + path);
        } catch (ClassNotFoundException classNotFoundException) {
            throw new InvalidCatalogException(classNotFoundException);
        }

        return null;
    }

    public static void view(Item item) {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(new File(item.getLocation()));
        } catch (IOException ioException) {
            System.err.println("Unexpected error reading file " + item.getLocation());
        }
    }
}

