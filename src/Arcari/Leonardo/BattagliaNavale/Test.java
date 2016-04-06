package Arcari.Leonardo.BattagliaNavale;

/**
 * Created by leonardoarcari on 07/04/16.
 */
public class Test {
    public static void main(String[] args) {
        Partita partita = new Partita();
        Monitor monitor = new Monitor(partita);
        partita.gioca();
    }
}
