import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Samuele on 21/04/2016.
 */
public class ServerMain {
    private Socket socket;
    ArrayList<Giocatore> giocatori = new ArrayList<>();
    private int numberOfClient=0;

    public static void main(String[] args) throws IOException {
        ServerMain main = new ServerMain();
        main.run();
    }

    private void run() throws IOException {
        ArrayList<Socket> arrayOfSockets = new ArrayList<>();
        ServerSocket server = new ServerSocket(3000);
        ExecutorService executor = Executors.newCachedThreadPool();

        while (true){
            arrayOfSockets.add(server.accept());
            Runnable serverThread;
            serverThread = new ServerThread(arrayOfSockets.get(numberOfClient),this);
            executor.execute(serverThread);
            numberOfClient++;
            System.out.println("Si è connesso un nuovo client");
        }
    }

    public void nuovoGiocatore(String user, String pass, int punti){
        giocatori.add(new Giocatore(user,pass,punti));
    }

    public boolean isTherePlayer(String user){
        for(int i=0;i<giocatori.size();i++) {
            if (giocatori.get(i).getNome().equals(user)) {
                return true;
            }
        }
        return false;
    }

    public void addPunti(String nome){
        for (int i=0;i<giocatori.size();i++){
            if (giocatori.get(i).getNome().equals(nome)){
                giocatori.get(i).addPunti();
                System.out.println("Aggiunto un punto al giocatore: "+giocatori.get(i).getNome());
            }
        }
    }


    public ArrayList<Giocatore> rank() {
        ArrayList<Giocatore> classifica = giocatori;
        int best = 0;

        if (giocatori.size() > 1) {
            for (int i = 0; i < giocatori.size(); i++) {
                for (int j = 0; j < giocatori.size()-1; j++) {
                    if (giocatori.get(i).getPunti() > classifica.get(j + 1).getPunti()) {
                        Giocatore gioc = classifica.get(j);
                        classifica.set(j, classifica.get(j + 1));
                        classifica.set(j + 1, gioc);
                    }
                }
            }
        }
        return classifica;
    }

    public int numberOfPlayers(){
        return numberOfClient;
    }
}
