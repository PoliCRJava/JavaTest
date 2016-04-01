package Arcari.Leonardo.SortAlgorithms;

/**
 * Simple class describing a Student.
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

    /**
     * Student extends Persona which implements Comparable<Persona>. Hence, compareTo()
     * overridden method still takes a Persona parameter casting to Student in case it's an instance of Student.
     *
     * @param o Student to compare with
     * @return 0 if a.equals(b), 1 if a > b, -1 otherwise.
     */
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
