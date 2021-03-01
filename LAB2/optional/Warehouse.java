package optional;

/**
 * Clasa derivata din clasa Source ce descrie un depozit.
 * @see Source
 */
public class Warehouse extends Source{

    /**
     * Creeaza un depozit nou.
     * @param name Numele depozitului.
     * @param capacity Capacitatea depozitului.
     */
    Warehouse(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    /**
     * Implementeaza metoda toString din clasa Source.
     * @return String-ul generat.
     * @see Source
     */
    @Override
    public String toString() {
        return "Warehouse{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
