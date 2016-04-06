package Arcari.Leonardo.BattagliaNavale;

/**
 * Created by leonardoarcari on 05/04/16.
 */
public interface Nave {
    boolean colpo(Coordinata c);
    String mostraStato(Coordinata c);
    boolean affondata();
}
