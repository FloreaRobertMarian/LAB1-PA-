package item;

public class Song extends Item {
    public Song(String id, String location) {
        this.id = id;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Song {id: " + this.id + ", location: " + this.location + "}";
    }
}
