package optional;

/**
 * Clasa derivata din clasa Source ce descrie o fabrica.
 * @see Source
 */
public class Factory extends Source{

    /**
     * Creeaza o fabrica noua.
     * @param name Numele fabricii.
     * @param capacity Capacitatea fabricii.
     */
    Factory(String name, int capacity) {
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
        return "Factory{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
