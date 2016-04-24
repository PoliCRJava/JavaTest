package Arcari.Leonardo.ThreadSocketGame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by leonardoarcari on 21/04/16.
 */
public class Server {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void startServer() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                executorService.submit(new ClientHandler(socket));
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
            return;
        }
    }

    public static void main(String[] args) {
        Server server = new Server(3000);
        server.startServer();
    }
}
