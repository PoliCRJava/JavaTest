package Arcari.Leonardo.ThreadSocketGame;

/**
 * Created by leonardoarcari on 21/04/16.
 */
public class Giocatore {
    private String username;
    private String password;
    private int record;

    public Giocatore(String username, String password, int record) {
        this.username = username;
        this.password = password;
        this.record = record;
    }

    public Giocatore(String username, String password) {
        this(username, password, 0);
    }

    public String getUsername() {
        return username;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public boolean checkCredentials(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public String toString() {
        return username + " " + password + " " + record;
    }
}
