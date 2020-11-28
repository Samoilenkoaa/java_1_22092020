package lesson6_advanced.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;


public class Server {

    private static int PORT = 8189;
    ServerSocket server = null;
    Socket socket = null;
    List<ClientHandler> clients;

    public Server() {
        clients = new Vector<>();

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");

            socket = server.accept();
            System.out.println("клиент подключился");
            clients.add(new ClientHandler(this, socket));

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                try {
                    String s = reader.readLine();
                    if (s.equals("exit")) {
                        break;
                    } else {
                        broadCastMsgFrobSRV(s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void broadCastMsg(String msg) {
        System.out.println("Клиент: " + msg);
        for (ClientHandler client : clients) {
            client.sendMsg(msg + "\n");

        }
    }

    void broadCastMsgFrobSRV(String msg) {
        System.out.println("Сервер: " + msg);
        for (ClientHandler client : clients) {
            client.sendMsg(msg + "\n");

        }
    }
}

