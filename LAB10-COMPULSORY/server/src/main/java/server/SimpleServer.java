package server;

import client.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    // Define the port on which the server is listening
    public static final int PORT = 8100;

    public static boolean running;

    public SimpleServer() throws IOException {
        running = true;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (running) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        }
    }
}