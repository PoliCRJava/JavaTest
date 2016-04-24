package Emanuele.Ghelfi.SocketGame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Emanuele on 21/04/2016.
 */
public class Server {
    private int port;
    private UserList users;

    public Server(int port){
        this.port = port;
        users = new UserList();
    }

    public Server(){
        port=3000;
        users = new UserList();
    }

    public void StartServer(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("First.Server started");

        while (true){
            try {
                Socket socket = serverSocket.accept();
                executorService.submit(new ClientHandler(socket,users));
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

        }

        executorService.shutdown();
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Server server = new Server(3000);
        server.StartServer();
    }


}
