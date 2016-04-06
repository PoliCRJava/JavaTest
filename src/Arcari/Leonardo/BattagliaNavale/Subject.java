package Arcari.Leonardo.BattagliaNavale;

/**
 * Created by leonardoarcari on 06/04/16.
 */
public interface Subject {
    void registerObserver(Observer o);
    void deleteObserver(Observer o);
    void notifyObservers();
}
