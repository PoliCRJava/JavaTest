package Arcari.Leonardo.BattagliaNavale;

/**
 * Created by leonardoarcari on 05/04/16.
 */
public class Direzione {
    public static final Direzione SU = new Direzione(0, 1);
    public static final Direzione GIU = new Direzione(0, -1);
    public static final Direzione DESTRA = new Direzione(1, 0);
    public static final Direzione SINISTRA = new Direzione(-1, 0);

    int incrX;
    int incrY;

    private Direzione(int incrX, int incrY) {
        this.incrX = incrX;
        this.incrY = incrY;
    }

    public static Direzione direzioneCasuale() {
        int dir = Double.valueOf(4 * Math.random()).intValue();

        if (dir == 0) return SU;
        else if (dir == 1) return GIU;
        else if (dir == 2) return DESTRA;
        else return SINISTRA;
    }
}
