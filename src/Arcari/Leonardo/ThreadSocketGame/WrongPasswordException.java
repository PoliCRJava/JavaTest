package Arcari.Leonardo.ThreadSocketGame;

/**
 * Created by leonardoarcari on 21/04/16.
 */
public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
