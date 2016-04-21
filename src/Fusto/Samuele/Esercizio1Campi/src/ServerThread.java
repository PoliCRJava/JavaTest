import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Samuele on 21/04/2016.
 */
public class ServerThread implements  Runnable {
    private Socket mySocket;
    private ServerMain serverMain;
    public ServerThread(Socket mySocket, ServerMain serverMain){
        this.mySocket=mySocket;
        this.serverMain=serverMain;
    }

    @Override
    public void run() {
        int livello=0;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(this.mySocket.getInputStream()));
            PrintWriter out = new PrintWriter(mySocket.getOutputStream(),true);

            System.out.println(in.readLine());
            String user = in.readLine();
            System.out.println("letto"+user);
            String pass = in.readLine();
            System.out.println("letto: "+pass);


            //se il giocatore non è già presente all'interno della struttura dati:
            if (!serverMain.isTherePlayer(user)){
                System.out.println("Giocatore Nuovo!!");
                serverMain.nuovoGiocatore(user,pass,0);
                out.println("True");
            }
            else {
                System.out.println("Giocatore già esistente!!");
                out.println("False");
            }

            System.out.println("Login effettuato.");
            boolean clientOnline=true;


            while (clientOnline){
                switch (in.readLine()){


                    case "partita": {
                        Random rand=new Random();
                        String number = String.valueOf(rand.nextInt(9 + 1));
                        boolean win = true;

                        while (win) {
                            for (int i = 0; i < livello + 2; i++) {
                                int randomNum = rand.nextInt((9 + 1));
                                number+=String.valueOf(randomNum);
                            }
                            out.println(number);

                            System.out.println("Ho inviato il numero: "+number);

                            String numberUser = in.readLine();
                            if (number.equals(numberUser)) {
                                win=true;
                                out.println("True");
                                serverMain.addPunti(user);
                                System.out.println("Ha vinto!");
                                livello++;
                            } else {
                                win=false;
                                out.println("False");
                                livello=1;
                            }
                            number= String.valueOf(rand.nextInt(9 + 1));
                        }
                    }break;

                    case "record":{
                        int numberOfPlayer=serverMain.numberOfPlayers();
                        System.out.println("Numbero di giocatori: "+numberOfPlayer);
                        out.println(numberOfPlayer);
                        ArrayList<Giocatore> classifica = serverMain.rank();

                        for (int i=0; i<classifica.size();i++){
                            String row = classifica.get(i).getNome()+" "+classifica.get(i).getPunti();
                            out.println(row);
                        }
                    } break;
                    case "fine":{
                        System.out.println("Client disconnesso.");
                        clientOnline=false;

                    }

                }

            }


            out.close();
            in.close();
            mySocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
