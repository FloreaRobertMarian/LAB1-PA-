package compulsory;

import java.util.Arrays;

public class Problem {
    private Source[] surse;
    private Destination[] destinatii;
    private int[][] cost;


    public Problem(Source[] surse, Destination[] destinatii, int[][] cost) {
        this.surse = surse;
        this.destinatii = destinatii;
        this.cost = cost;
    }

    public Source[] getSurse() {
        return surse;
    }

    public void setSurse(Source[] surse) {
        this.surse = surse;
    }

    public Destination[] getDestinatii() {
        return destinatii;
    }

    public void setDestinatii(Destination[] destinatii) {
        this.destinatii = destinatii;
    }

    public int[][] getCost() {
        return cost;
    }

    public void setCost(int[][] cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Problem{\n" +
                "surse=" + Arrays.toString(surse) +
                "\ndestinatii=" + Arrays.toString(destinatii) +
                "\ncost=" + Arrays.deepToString(cost) +
                "\n}";
    }
}
