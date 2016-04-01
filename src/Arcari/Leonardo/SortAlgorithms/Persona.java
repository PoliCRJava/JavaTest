package Arcari.Leonardo.SortAlgorithms;

/**
 * Simple class describing a Person implementing Comparable interface.
 */
public class Persona implements Comparable<Persona> {
    private String name;
    private String surname;
    private String address;

    public Persona(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    @Override
    public String toString() {
        return (surname + " " + name);
    }

    @Override
    public int compareTo(Persona o) {
        if (this.surname.compareTo(o.surname) > 0 ||
                (this.surname.compareTo(o.surname) == 0 && this.name.compareTo(o.name) > 0))
            return 1;
        else if (this.surname.compareTo(o.surname) == 0 && this.name.compareTo(o.name) == 0)
            return 0;
        else return -1;
    }
}
