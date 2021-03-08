package locatii;

public class Restaurant extends Location implements Classifiable{
    private String rank;

    public Restaurant() {
        this(null);
    }

    public Restaurant(String name) {
        super(name);
    }

    @Override
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
