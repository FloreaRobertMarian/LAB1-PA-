package compulsory;

public class Main {
    public static void main(String[] args) {
        Source[] surse = {
                new Source("S1", SourceType.FACTORY, 10),
                new Source("S2", SourceType.WAREHOUSE, 35),
                new Source("S3", SourceType.WAREHOUSE, 25)
        };

        Destination[] destinatii = {
                new Destination("D1", 20),
                new Destination("D2", 25),
                new Destination("D3", 25)
        };

        int[][] cost = {
                {2, 3, 1},
                {5, 4, 8},
                {5, 6, 8}
        };

        Problem problema = new Problem(surse, destinatii, cost);

        System.out.println(problema);
    }
}
