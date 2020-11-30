package lesson7_advanced_2.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    Server server = null;
    Socket socket = null;
    DataInputStream in;
    DataOutputStream out;
    private  String nickname;


    public ClientHandler(Server server, Socket socket) {  // создаем конструктор который будет отвечать за подключение новых клиентов
        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream()); // входной поток мы подаем в сокет
            out = new DataOutputStream(socket.getOutputStream()); // выходной поток мы подаем в сокет

            new Thread(() -> { // в этом потоке запускаем каждый раз работу с новым клиентом
                    try {
                        // цикл аунтификации для того что бы если пользователь ошибся то можно бы было еще раз зайти
                        while (true){
                            String str = in.readUTF();

                            if (str.startsWith("/auth")){
                                String[] token = str.split("\\s");
                                String newNick = server.getAuthService().getNicknameByLoginAndPassword(token[1], token[2]);

                                if (newNick != null){
                                    nickname = newNick;
                                    sendMsg("/authok " + nickname);
                                    server.subscribe(this);
                                    System.out.println("Клиент " + nickname + " подключился");
                                    break;
                                }else {
                                    sendMsg("Неверный логин / пароль");
                                }
                            }
                        }

                        // цикл работы
                        while (true) {
                            String str = in.readUTF(); // мы хотим в бесконечном цикле получать данные из входного потока

                            if (str.equals("/end")) {
                                out.writeUTF("/end");
                                break;
                            }
                            server.broadCastMsg(this, str); // посылаем всем клиентам собщение
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("Клиент отключился");
                        server.unsubscribe(this); // убираем отключившегося клиента
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * метод для отправки сообщений каждого пользователя на сервер
     * @param msg
     */
    void sendMsg(String msg) {
        try {
            out.writeUTF(msg); // отправим на сервер то что мы ввели
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getNickname(){

        return nickname;
    }
}
