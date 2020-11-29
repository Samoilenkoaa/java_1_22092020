package lesson7_advanced.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;


public class Server {

    private static int PORT = 8189; // создаем порт
    ServerSocket server = null; // создаем сервер
    Socket socket = null; // создаем соект которй выделяет сервер
    List<ClientHandler> clients; // создаем лист для того что бы всем отправлять сообщения
    private AuthService authService;

    public Server() {
        clients = new Vector<>(); // создаем лист в котором будет хранить клиентов
        authService = new SimpleAuthService();

        try {
            server = new ServerSocket(PORT); // получаем сервер сокет которому передаем порт для подключения
            System.out.println("Сервер запущен"); // выводим что сервер запущен

            while (true) {
                socket = server.accept(); // начинаем ждать что бы кто нить подключился
                System.out.println("Клиент подключился"); // выводим в консоль что клиент подключился
                new ClientHandler(this, socket); // создаем новых клиентов. передаем ему сервер и сокет
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * метод для отправки сообений всем клиентам
     *
     * @param msg
     */
    void broadCastMsg(ClientHandler sender, String msg) {
        String message = String.format("%s : %s", sender.getNickname(), msg); //ш будем видеть какой клиен отправляет сообщения
        if (msg.startsWith("/w")) {
            for (ClientHandler client : clients) { // проходимся по всему списку клиентов
                if (client.getNickname().equals(sender.getNickname()) || client.getNickname().equals(msg.split(" ")[1])) {
                    // 1) если никнейм из массива equals 2 элименту при разбиве строки на массив
                    // 2) никнейм из массива клиентов сравниваем с ником отправителя
                    message = String.format("%s : %s", sender.getNickname(), msg.split(" ",3)[2]);
                    client.sendMsg(message + "\n");
                }
            }
        } else {
            for (ClientHandler client : clients) {
                client.sendMsg(message + "\n");
            }

        }
    }


    /**
     * Производит запись нового клиента в наш лист с клиентами
     *
     * @param clientHandler
     */
    public void subscribe(ClientHandler clientHandler) {

        clients.add(clientHandler);
    }

    /**
     * Метод после выхода одного из клиентов он его будет убирать из нашего листа что бы не ьыло ошибок
     *
     * @param clientHandler
     */
    public void unsubscribe(ClientHandler clientHandler) {

        clients.remove(clientHandler);
    }


    /**
     * метод в котором будем получать доступ пользователя
     *
     * @return
     */
    public AuthService getAuthService() {
        return authService;
    }
}

