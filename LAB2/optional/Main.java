package optional;

/**
 * Clasa folosita pentru a rula si testa programul.
 */
public class Main {
    public static void main(String[] args) {
        Source[] surse = {
                new Factory("S1", 10),
                new Factory("S2", 25),
                new Warehouse("S3", 25)
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

        Solution sol = Greedy.solve(problema);
        System.out.println(sol);
    }
}
