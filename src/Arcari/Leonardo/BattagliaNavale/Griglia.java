package Arcari.Leonardo.BattagliaNavale;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonardoarcari on 05/04/16.
 */
public class Griglia {
    Nave[][] g;
    List<RealNave> navi;

    public Griglia() {
        g = new Nave[Costanti.DIM][Costanti.DIM];
        navi = new ArrayList<>(Costanti.NUMNAVI);
        allocaNavi();
        riempiConNullObject();
    }

    private void allocaNavi() {
        for (int i = 1; i <= Costanti.NUMNAVI; i++) {
            int dim = (Costanti.NUMNAVI - i) / 2;
            allocaNave(dim);
        }
    }

    private void allocaNave(int dimensioneNave) {
        boolean ok = false;
        PosizioneNave pn = null;

        while (!ok) {
            pn = PosizioneNave.posizioneNaveCasuale(dimensioneNave);
            ok = controllaSeLibero(pn);
        }

        RealNave n = new RealNave(pn);
        posaNave(n);
    }

    private boolean controllaSeLibero(PosizioneNave pn) {
        for (int i = 0; i < pn.dimensioneNave; i++) {
            Coordinata tc = pn.calcolaCoordinataOccupata(i);
            if (tc.x < 0 || tc.x >= Costanti.DIM
                    || tc.y < 0 || tc.y >= Costanti.DIM || g[tc.x][tc.y] != null)
                return false;
        }
        return true;
    }

    private void posaNave(RealNave nave) {
        navi.add(nave);

        for (int i = 0; i < nave.getPn().dimensioneNave; i++) {
            Coordinata tc = nave.getPn().calcolaCoordinataOccupata(i);
            g[tc.x][tc.y] = nave;
        }
    }

    private void riempiConNullObject() {
        for (int i = 0; i < Costanti.DIM; i++) {
            for (int k = 0; k < Costanti.DIM; k++) {
                if (g[i][k] == null)
                    g[i][k] = NullNave.getInstance();
            }
        }
    }

    public String mostraStatoCoordinata(Coordinata c) {
        if (c.x < Costanti.DIM && c.y < Costanti.DIM) {
            return g[c.x][c.y].mostraStato(c);
        }
        throw new IndexOutOfBoundsException();
    }

    private boolean spara(Coordinata c) {
        return g[c.x][c.y].colpo(c);
    }

    public EventiGioco mossa() {
        Coordinata c = Coordinata.coordinataCasuale(Costanti.DIM);

        if (spara(c)) {
            if (g[c.x][c.y].affondata()) {
                return EventiGioco.AFFONDATO;
            } else return EventiGioco.COLPITO;
        } else return EventiGioco.ACQUA;
    }

    public boolean sconfitta() {
        for (RealNave aNavi : navi) {
            if (!aNavi.affondata()) return false;
        }
        return true;
    }

}
