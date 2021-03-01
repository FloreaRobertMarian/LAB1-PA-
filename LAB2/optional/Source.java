package optional;

import java.util.Objects;

/**
 * Clasa abstracta ce descrie o sursa din problema de transport.
 */
public abstract class Source {
    protected String name;      // numele sursei
    protected int capacity;     // capacitatea

    /**
     * Getter pentru numele sursei.
     * @return Numele sursei.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter pentru numele sursei.
     * @param name Noul nume.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter pentru capacitatea sursei.
     * @return Capacitatea sursei.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Setter pentru capacitatea sursei.
     * @param capacity Noua capacitate.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Genereaza un String ce contine informatii despre sursa.
     * Trebuie implementat in clasele derivate.
     * @return String-ul generat.
     */
    @Override
    public abstract String toString();

    /**
     * Verifica daca un alt obiect este identic cu sursa.
     * @param o Obiectul de verificat.
     * @return True daca sunt identice, false altfel.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return Objects.equals(name, source.name);
    }

    /**
     * Genereaza un cod hash unic pentru sursa.
     * @return Codul generat.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
