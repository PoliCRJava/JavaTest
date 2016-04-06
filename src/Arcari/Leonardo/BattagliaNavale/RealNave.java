package Arcari.Leonardo.BattagliaNavale;

/**
 * Created by leonardoarcari on 05/04/16.
 */
public class RealNave implements Nave {
    private PosizioneNave pn;
    private boolean[] colpita;

    public RealNave(PosizioneNave pn) {
        this.pn = pn;
        this.colpita = new boolean[pn.dimensioneNave];
    }

    @Override
    public boolean colpo(Coordinata c) {
        for (int k = 0; k < pn.dimensioneNave; k++) {
            Coordinata tc = pn.calcolaCoordinataOccupata(k);
            if (tc.x == c.x && tc.y == c.y) {
                this.colpita[k] = true;
                return true;
            }
        } return false;
    }

    @Override
    public String mostraStato(Coordinata c) {
        for (int k = 0; k < pn.dimensioneNave; k++) {
            Coordinata tc = pn.calcolaCoordinataOccupata(k);
            if (tc.x == c.x && tc.y == c.y && colpita[k])
                return " X ";
        } return " " + pn.dimensioneNave + " ";
    }

    @Override
    public boolean affondata() {
        for (int k = 0; k < pn.dimensioneNave; k++) {
            if (!colpita[k])
                return false;
        } return true;
    }

    public PosizioneNave getPn() {
        return pn;
    }
}
