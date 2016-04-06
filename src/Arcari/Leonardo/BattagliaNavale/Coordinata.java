package Arcari.Leonardo.BattagliaNavale;

/**
 * Created by leonardoarcari on 05/04/16.
 */
public class Coordinata {
    final int x;
    final int y;

    public Coordinata(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinata coordinataCasuale(int range) {
        int x = Double.valueOf(range * Math.random()).intValue();
        int y = Double.valueOf(range * Math.random()).intValue();

        return new Coordinata(x, y);
    }
}
