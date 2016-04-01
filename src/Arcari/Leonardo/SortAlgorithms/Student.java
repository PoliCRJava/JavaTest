package Arcari.Leonardo.SortAlgorithms;

/**
 * Created by leonardoarcari on 22/03/16.
 */
public class Student extends Persona {
    private String id;

    public Student(String name, String surname, String address, String id) {
        super(name, surname, address);
        this.id = id;
    }

    @Override
    public String toString() {
        return (super.toString() + ", id n. " + id);
    }

    @Override
    public int compareTo(Persona o) {
        int i = super.compareTo(o);
        if (i != 0) return i;

        if (o instanceof Student) {
            Student other = (Student) o;
            return this.id.compareTo(other.id);
        } else return 0;
    }
}
