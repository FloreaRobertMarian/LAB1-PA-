package optional;

import java.util.Vector;

/**
 * Clasa ce descrie o solutie a problemei de transport.
 */
public class Solution {

    /**
     * Clasa ce descrie o tranzactie de la o sursa la o destinatie.
     * Retine sursa, destinatia, cantitatea si costul unui transport.
     */
    private static class Transport {
        public Source s;
        public Destination d;
        public int cantitate;
        public int cost;

        /**
         * Creeaza un transport nou cu specificatiile date.
         * @param s Sursa de unde provine marfa.
         * @param d Destinatia la care va ajunge.
         * @param cantitate Cantitatea transportata.
         * @param cost Costul transportului (per unitate).
         */
        Transport(Source s, Destination d, int cantitate, int cost) {
            this.s = s;
            this.d = d;
            this.cantitate = cantitate;
            this.cost = cost;
        }

        /**
         * Genereaza un String de forma "[sursa] -> [destinatie]: cantitate * cost pentru a descrie o tranzactie.
         * @return String-ul generat.
         */
        @Override
        public String toString() {
            return s.getName() + " -> " + d.getName() + ": " + cantitate + " units * cost " + cost + " = " + cost * cantitate;
        }
    }

    private final Vector<Transport> tranzactii;
    private int totalCost;

    /**
     * Creeaza o solutie noua fara nicio tranzactie.
     */
    Solution() {
        tranzactii = new Vector<>();
        totalCost = 0;
    }

    /**
     * Adauga un transport la solutie.
     * @param s Sursa de unde provine marfa.
     * @param d Destinatia la care va ajunge.
     * @param cantitate Cantitatea transportata.
     * @param cost Costul transportului (per unitate).
     */
    public void addTransport(Source s, Destination d, int cantitate, int cost) {
        tranzactii.add(new Transport(s, d, cantitate, cost));
        totalCost += cantitate * cost;
    }

    /**
     * Genereaza un String ce va contine informatii despre toate tranzactiile care compun solutia.
     * @return String-ul generat.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Solutie:\n");
        for(Transport tranzactie:tranzactii)
            s.append(tranzactie).append("\n");
        s.append("Total cost: ").append(totalCost);

        return s.toString();
    }
}
