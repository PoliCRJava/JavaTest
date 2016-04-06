package Arcari.Leonardo.BattagliaNavale;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonardoarcari on 06/04/16.
 */
public class Partita implements Subject {
    private Griglia[] g = new Griglia[2];
    private List<Observer> observers;

    private EventiGioco[] ultimoEvento;
    private int ultimoGiocatore;

    public Partita() {
        g[0] = new Griglia();
        g[1] = new Griglia();
        observers = new ArrayList<>();

        // Game status
        ultimoEvento = new EventiGioco[2];
    }

    void gioca() {
        while (true) {
            if (!mossa(1))
                break;
            if (!mossa(2))
                break;
        }
    }

    private boolean mossa(int i) {
        EventiGioco esitoMossa = g[i - 1].mossa();
        setUltimoEvento(esitoMossa, i);

        if (esitoMossa == EventiGioco.AFFONDATO) {
            if (g[i - 1].sconfitta()) {
                setUltimoEvento(EventiGioco.SCONFITTA, i);
                return false;
            }
        }
        return true;
    }

    private void setUltimoEvento(EventiGioco evento, int giocatore) {
        ultimoEvento[giocatore - 1] = evento;
        ultimoGiocatore = giocatore;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    public Nave naveInCoordinata(Coordinata c, int giocatore) {
        if (c.x < Costanti.DIM && c.y < Costanti.DIM) {
            return g[giocatore - 1].g[c.x][c.y];
        } else throw new IndexOutOfBoundsException();
    }

    public int getUltimoGiocatore() {
        return ultimoGiocatore;
    }

    public EventiGioco getUltimoEvento(int giocatore) {
        return ultimoEvento[giocatore - 1];
    }
}
