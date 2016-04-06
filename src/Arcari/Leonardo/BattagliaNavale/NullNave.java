package Arcari.Leonardo.BattagliaNavale;

/**
 * Created by leonardoarcari on 05/04/16.
 */
public class NullNave implements Nave {
    private static NullNave instance = null;

    public static NullNave getInstance() {
        if (instance == null) {
            instance = new NullNave();
            return instance;
        } else return instance;
    }

    @Override
    public boolean colpo(Coordinata c) {
        return false;
    }

    @Override
    public String mostraStato(Coordinata c) {
        return " 0 ";
    }

    @Override
    public boolean affondata() {
        return false;
    }
}
