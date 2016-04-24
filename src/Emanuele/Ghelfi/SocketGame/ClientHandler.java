package Emanuele.Ghelfi.SocketGame;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Emanuele on 21/04/2016.
 */
public class ClientHandler implements Runnable {

    private Socket socket;
    private Scanner in;
    private PrintWriter out;
    private User currentUser;
    private UserList users;

    public ClientHandler(Socket socket, UserList users){
        this.socket = socket;
        this.users = users;
    }


    @Override
    public void run() {

        try {
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(),true);
            System.out.println("First.Client handler started");

            while (true){
                String line = in.nextLine();
                ReadCommand(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void ReadCommand(String line) {
            switch (line){
                case Constants.LOGIN:
                    DoLogin();
                    break;
                case Constants.PARTITA:
                    StartGame();
                    break;
                case Constants.RECORD:
                    SendRecord();
                    break;
                default:
                    out.println("NOT CORRECT");
                    break;
            }
    }

    private void SendRecord() {
        //Send users length
        out.println(""+users.size());
        //send record
        Iterator<User> userIterator = users.getIterator();
        while (userIterator.hasNext()){
            out.println(userIterator.next());
        }
    }


    private void StartGame() {
        boolean correct = true;
        //note a single Random object is reused here
        String randomSequence = "";
        int sequenceLength = 3;
        while (correct) {
            randomSequence="";
            Random randomGenerator = new Random();
            for (int idx = 1; idx <= sequenceLength; ++idx) {
                int randomInt = randomGenerator.nextInt(10);
                System.out.println("Generated : " + randomInt);
                randomSequence = randomSequence + randomInt;
            }
            out.println(randomSequence);
            String line = in.nextLine();
            System.out.println("GENERATED: "+randomSequence);
            System.out.println("FROM CLIENT: "+line);
            if(line.equals(randomSequence)) {
                correct = true;
                sequenceLength++;
                users.UpdateMaxPoint(currentUser,sequenceLength);
                out.println("true");
            }
            else {
                correct=false;
                out.println("false");
            }

        }
    }



    private void DoLogin() {
        String user = in.nextLine();
        String pw = in.nextLine();
        User tmpUser = new User(pw,user);
        if(users.Login(tmpUser)){
            out.println("true");
            currentUser = tmpUser;
        }
        else {
            out.println("false");
        }


    }


}
