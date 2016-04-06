package Arcari.Leonardo.BattagliaNavale;

/**
 * Created by leonardoarcari on 06/04/16.
 */
public class Monitor implements Observer {
    private Subject subject;
    private String trattiniTitoloGriglia;
    private String trattiniFondoGriglia;

    public Monitor(Subject subject) {
        this.subject = subject;
        trattiniTitoloGriglia = creaTrattiniGriglia(Costanti.N_TRATTINI);
        trattiniFondoGriglia = creaTrattiniGriglia(Costanti.COLONNE_GRIGLIA);
        subject.registerObserver(this);
    }

    @Override
    public void update(Subject subject) {
        if (subject instanceof Partita)
            mostraPartita((Partita) subject);
    }

    public void mostraPartita(Partita partita) {
        int ultimoGiocatore = partita.getUltimoGiocatore();
        EventiGioco ultimoEvento = partita.getUltimoEvento(ultimoGiocatore);
        String giocatore = "Giocatore " + ultimoGiocatore;

        if (ultimoEvento == EventiGioco.ACQUA) {
            System.out.println(giocatore + ": Acqua!");
        } else if (ultimoEvento == EventiGioco.COLPITO) {
            System.out.println(giocatore + ": La tua nave è stata colpita!");
            stampaGriglia(partita);
        } else if (ultimoEvento == EventiGioco.AFFONDATO) {
            System.out.println(giocatore + ": La tua nave è stata colpita e affondata!");
            stampaGriglia(partita);
        } else if (ultimoEvento == EventiGioco.SCONFITTA) {
            System.out.println(giocatore + " ha perso!");
        }
    }

    private void stampaGriglia(Partita partita) {
        int ultimoGiocatore = partita.getUltimoGiocatore();
        String giocatore = "Giocatore " + ultimoGiocatore;
        System.out.println(trattiniTitoloGriglia + " Griglia " + giocatore + " " + trattiniTitoloGriglia);
        for (int i = 0; i < Costanti.DIM; i++) {
            for (int k = 0; k < Costanti.DIM; k++) {
                Coordinata c = new Coordinata(i, k);
                Nave nave = partita.naveInCoordinata(c, partita.getUltimoGiocatore());
                System.out.print(nave.mostraStato(c));
            } System.out.println();
        } System.out.println(trattiniFondoGriglia);
    }

    private String creaTrattiniGriglia(int n_trattini) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n_trattini; i++) {
            sb.append("-");
        } return sb.toString();
    }


}
