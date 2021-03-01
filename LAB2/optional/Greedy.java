package optional;

/**
 * Clasa in care este implementat un algoritm de rezolvare greedy a problemei de transport.
 */
public class Greedy {
    /**
     * Aceasta metoda de rezolvare nu incearca minimizarea costurilor de transport, ci doar satisface cererile.
     * @param pb Problema ce va fi rezolvata.
     * @return Solutia gasita
     * @see Solution
     */
    public static Solution solve(Problem pb) {
        Solution sol =  new Solution();

        Source[] surse = pb.getSurse();
        Destination[] destinatii = pb.getDestinatii();
        int[][] cost = pb.getCost();
        int[] supply = new int[pb.getSurse().length];
        int[] demand = new int[pb.getDestinatii().length];

        for(int i=0; i<supply.length; i++)
            supply[i] = surse[i].getCapacity();

        for(int i=0; i<demand.length; i++)
            demand[i] = destinatii[i].getDemand();

        for(int i=0; i<supply.length; i++) {
            if(supply[i] == 0)
                continue;

            for(int j=0; j<demand.length; j++) {
                if(demand[j] == 0)
                    continue;

                // sursa nu are destul -> trimite tot ce are la destinatie
                if(supply[i] <= demand[j]) {
                    sol.addTransport(surse[i], destinatii[j], supply[i], cost[i][j]);
                    demand[j] -= supply[i];
                    supply[i] = 0;
                    break;
                }

                // sursa are prea mult -> trimite cat de mult poate
                sol.addTransport(surse[i], destinatii[j], demand[j], cost[i][j]);
                supply[i] -= demand[j];
                demand[j] = 0;
            }
        }

        return sol;
    }
}
