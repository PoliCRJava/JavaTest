package Arcari.Leonardo.ThreadSocketGame;

/**
 * Created by leonardoarcari on 21/04/16.
 */
public class Game {
    private int livello;
    private String ultimaSequenza;
    private Giocatore giocatore;

    public Game(Giocatore giocatore) {
        this.giocatore = giocatore;
        livello = 1;
    }

    public String generaSequenza() {
        ultimaSequenza = "";
        for (int i = 0; i < livello; i++) {
            ultimaSequenza += Double.valueOf(Math.random() * 9).intValue();
        }
        return ultimaSequenza;
    }

    public boolean controllaSequenza(String sequenza) {
        boolean result = false;
        if (sequenza.equals(ultimaSequenza)) {
            if (livello > giocatore.getRecord()) {
                giocatore.setRecord(livello);
            }
            livello++;
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public void resetGame() {
        livello = 1;
        ultimaSequenza = "";
    }
}
