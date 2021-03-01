package optional;

import java.util.Objects;

/**
 * Clasa ce descrie o destinatie din problema de transport.
 */
public class Destination {
    private String name;    // numele destinatiei
    private int demand;     // cererea

    /**
     * Creeaza o destinatie noua.
     * @param name Numele destinatiei.
     * @param demand Cererea.
     */
    public Destination(String name, int demand) {
        this.name = name;
        this.demand = demand;
    }

    /**
     * Getter pentru numele destinatiei.
     * @return Numele destinatiei.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter pentru numele destinatiei.
     * @param name Numele nou.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter pentru cererea destinatiei.
     * @return Cererea destinatiei.
     */
    public int getDemand() {
        return demand;
    }

    /**
     * Setter pentru cererea destinatiei.
     * @param demand Noua cerere.
     */
    public void setDemand(int demand) {
        this.demand = demand;
    }

    /**
     * Genereaza un String ce contine informatii despre destinatie.
     * @return String-ul generat.
     */
    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                ", demand=" + demand +
                '}';
    }

    /**
     * Verifica daca un alt obiect este identic cu destinatia.
     * @param o Obiectul de verificat.
     * @return True daca sunt identice, false altfel.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return Objects.equals(name, that.name);
    }

    /**
     * Genereaza un cod hash unic pentru destinatie.
     * @return Codul generat.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
