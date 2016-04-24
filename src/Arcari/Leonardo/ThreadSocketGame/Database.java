package Arcari.Leonardo.ThreadSocketGame;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by leonardoarcari on 21/04/16.
 */
public class Database {
    private volatile static Database instance = null;

    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    private Map<String, Giocatore> utentiRegistrati;

    private Database() {
        utentiRegistrati = Collections.synchronizedMap(new HashMap<>());
    }

    public boolean isRegistered(String username) {
        return utentiRegistrati.containsKey(username);
    }

    public Giocatore register(String username, String password) {
        if (!isRegistered(username)) {
            Giocatore giocatore = new Giocatore(username, password);
            utentiRegistrati.put(username, giocatore);
            return giocatore;
        } else {
            throw new KeyAlreadyExistsException("Giocatore già presente");
        }
    }

    public Iterator<Giocatore> getGiocatoreIterator() {
        return utentiRegistrati.values().iterator();
    }

    public Giocatore getGiocatore(String username) {
        return utentiRegistrati.get(username);
    }

    public int numeroGiocatori() {
        return utentiRegistrati.size();
    }
}
