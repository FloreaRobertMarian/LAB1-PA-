package optional;

import java.util.Arrays;

/**
 * Clasa ce descrie o instanta a problemei de transport.
 */
public class Problem {
    private Source[] surse;
    private Destination[] destinatii;
    private int[][] cost;

    /**
     * Creeaza o problema cu sursele, destinatiile si costurile date.
     * @param surse Sursele problemei.
     * @param destinatii Destinatiile problemei.
     * @param cost Matricea de cost asociata problemei.
     * @see Source
     * @see Destination
     */
    public Problem(Source[] surse, Destination[] destinatii, int[][] cost) {
        if (!checkSources(surse))
            return;

        if (!checkDestinations(destinatii))
            return;

        this.surse = surse;
        this.destinatii = destinatii;
        this.cost = cost;
    }

    /**
     * Verifica sa nu exista vreo sursa duplicat in lista de surse data ca parametru.
     * @param surse Lista de surse ce va fi verificata.
     * @return True daca nu exista duplicate, altfel false.
     */
    public static boolean checkSources(Source[] surse) {
        for (int i = 0; i < surse.length - 1; i++)
            for (int j = i + 1; j < surse.length; j++)
                if (surse[i].equals(surse[j])) {
                    System.out.println("Sursa " + surse[i] + " apare de 2 ori! Nu s-a putut construi problema.");
                    return false;
                }

        return true;
    }

    /**
     * Verifica sa nu exista vreo destinatie duplicat in lista de destinatii data ca parametru.
     * @param destinatii Lista de destinatii ce va fi verificata.
     * @return True daca nu exista duplicate, altfel false.
     */
    public static boolean checkDestinations(Destination[] destinatii) {
        for (int i = 0; i < destinatii.length - 1; i++)
            for (int j = i + 1; j < destinatii.length; j++)
                if (destinatii[i].equals(destinatii[j])) {
                    System.out.println("Destinatia " + destinatii[i] + " apare de 2 ori! Nu s-a putut construi problema.");
                    return false;
                }

        return true;
    }

    /**
     * Getter pentru sursele problemei.
     * @return Lista de surse.
     */
    public Source[] getSurse() {
        return surse;
    }

    /**
     * Setter pentru sursele problemei.
     * @param surse Noua lista de surse.
     */
    public void setSurse(Source[] surse) {
        this.surse = surse;
    }

    /**
     * Getter pentru destinatiile problemei.
     * @return Lista de destinatii.
     */
    public Destination[] getDestinatii() {
        return destinatii;
    }

    /**
     * Setter pentru destinatiile problemei.
     * @param destinatii Noua lista de destinatii.
     */
    public void setDestinatii(Destination[] destinatii) {
        this.destinatii = destinatii;
    }

    /**
     * Getter pentru matricea de costuri asociata problemei.
     * @return Matricea de costuri.
     */
    public int[][] getCost() {
        return cost;
    }

    /**
     * Setter pentru matricea de costuri asociata problemei.
     * @param cost Noua matrice de costuri.
     */
    public void setCost(int[][] cost) {
        this.cost = cost;
    }

    /**
     * Genereaza un String cu informatii despre problema.
     * @return String-ul generat.
     * @see String
     */
    @Override
    public String toString() {
        return "Problem{\n" +
                "surse=" + Arrays.toString(surse) +
                "\ndestinatii=" + Arrays.toString(destinatii) +
                "\ncost=" + Arrays.deepToString(cost) +
                "\n}";
    }
}
