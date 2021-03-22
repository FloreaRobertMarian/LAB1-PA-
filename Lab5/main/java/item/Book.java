package item;

public class Book extends Item {
    public Book(String id, String location) {
        this.id = id;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Book {id: " + this.id + ", location: " + this.location + "}";
    }
}
