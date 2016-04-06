package Arcari.Leonardo.BattagliaNavale;

/**
 * Created by leonardoarcari on 05/04/16.
 */
public class PosizioneNave {
    Coordinata coordinata;
    Direzione direzione;
    int dimensioneNave;

    private PosizioneNave(Coordinata coordinata, Direzione direzione, int dimensioneNave) {
        this.coordinata = coordinata;
        this.direzione = direzione;
        this.dimensioneNave = dimensioneNave;
    }

    public static PosizioneNave posizioneNaveCasuale(int dimensioneNave) {
        Coordinata c = Coordinata.coordinataCasuale(Costanti.DIM);
        Direzione d = Direzione.direzioneCasuale();

        return new PosizioneNave(c, d, dimensioneNave);
    }

    Coordinata calcolaCoordinataOccupata(int passo) {
        int x = coordinata.x + direzione.incrX * passo;
        int y = coordinata.y + direzione.incrY * passo;
        return new Coordinata(x, y);
    }
}
