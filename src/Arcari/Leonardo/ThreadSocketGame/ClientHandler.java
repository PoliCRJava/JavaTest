package Arcari.Leonardo.ThreadSocketGame;

import java.io.*;
import java.net.Socket;
import java.util.Iterator;

/**
 * Created by leonardoarcari on 21/04/16.
 */
public class ClientHandler implements Runnable{
    private Socket socket;
    private Login login;
    private Game game;
    private Giocatore giocatore;
    private BufferedReader input;
    private BufferedWriter output;

    private static final String LOGIN_MESSAGE = "login";
    private static final String PARTITA = "partita";
    private static final String RECORD = "record";
    private static final String FINE = "fine";

    public ClientHandler(Socket socket) {
        this.socket = socket;
        login = new Login();
    }

    @Override
    public void run() {
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            giocatore = waitLogin();
            game = new Game(giocatore);
            homePage();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
                input.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Giocatore waitLogin() {
        Giocatore giocatore = null;
        boolean loggato = false;
        while (!loggato) {
            try {
                String line = input.readLine();
                if (line.equals(LOGIN_MESSAGE)) {
                    String username = input.readLine();
                    String password = input.readLine();
                    try {
                        giocatore = login.loginUser(username, password);
                        loggato = true;
                    } catch (WrongPasswordException e) {
                        e.printStackTrace();
                    }
                    output.write(String.valueOf(loggato) + "\n");
                    output.flush();
                    System.out.println("Sending result " + loggato);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return giocatore;
    }

    private void homePage() {
        System.out.println("Waiting in homePage");
        boolean termina = false;
        while (!termina) {
            try {
                String command = input.readLine();
                switch (command) {
                    case PARTITA:
                        partita();
                        break;
                    case RECORD:
                        record();
                        break;
                    case FINE:
                        termina = true;
                        break;
                    default:
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void partita() {
        boolean successo = true;
        while (successo) {
            try {
                output.write(game.generaSequenza() + "\n");
                output.flush();
                String answer = input.readLine();
                successo = game.controllaSequenza(answer);
                output.write(String.valueOf(successo) + "\n");
                output.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        game.resetGame();
    }

    private void record() {
        try {
            output.write(String.valueOf(Database.getInstance().numeroGiocatori()) + "\n");
            output.flush();
            Iterator<Giocatore> iterator = Database.getInstance().getGiocatoreIterator();
            while (iterator.hasNext()) {
                output.write(iterator.next().toString() + "\n");
                output.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
