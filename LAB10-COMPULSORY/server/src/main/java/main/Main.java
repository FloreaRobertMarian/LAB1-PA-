package main;

import server.SimpleServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            SimpleServer server = new SimpleServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
