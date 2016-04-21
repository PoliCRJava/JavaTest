package Arcari.Leonardo.ThreadSocketGame;

/**
 * Created by leonardoarcari on 21/04/16.
 */
public class Login {
    public Giocatore loginUser(String username, String password) throws WrongPasswordException {
        if (Database.getInstance().isRegistered(username)) {
            Giocatore giocatore = Database.getInstance().getGiocatore(username);
            if (giocatore.checkCredentials(username, password)) {
                return giocatore;
            } else {
                throw new WrongPasswordException("Wrong password. Check again");
            }
        } else {
            return Database.getInstance().register(username, password);
        }
    }
}
