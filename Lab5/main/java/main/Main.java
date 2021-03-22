package main;

import catalog.Catalog;
import catalog.CatalogUtil;
import catalog.InvalidCatalogException;
import item.Book;
import item.Song;
import shell.Shell;

import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
        Shell shell = new Shell();
        shell.start();
    }

    private void testCreateSave() {
        Catalog catalog =
                new Catalog("My Books", "./catalog.ser");
        var song = new Song("bestSong", "./song.mp3");
        var book = new Book("bestBook", "./carte.txt");

        try {
            catalog.add(song);
            catalog.add(book);
        } catch (InvalidCatalogException invalidCatalogException) {
            System.err.println("Nu s-a putut gasi catalogul la locatia specifiata");
        }

        try {
            CatalogUtil.save(catalog);
        } catch (IOException ioException) {
            System.err.println("Catalogul nu a putut fi salvat!!");
        }
    }

    private void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load("./catalog.ser");
            CatalogUtil.view(catalog.findById("bestBook"));
            catalog.list();
        } catch (InvalidCatalogException invalidCatalogException) {
            System.err.println("Invalid catalog!");
        }
    }
}