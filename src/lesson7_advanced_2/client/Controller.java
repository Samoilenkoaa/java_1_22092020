package lesson7_advanced_2.client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;


//Контроллер отвечает за отправку сообщений клиентам

public class Controller implements Initializable {   // Для того что бы инизиализировать все соединение нужно шмплементировать Initializable
    @FXML
    public TextArea textArea;  // создаем поле текстАрия
    @FXML
    public TextField textField; // создаем поле ТекстФилд

    private final String IP_ADDRESS = "localhost"; //создаем IP
    private final int PORT = 8189; // создаем порт
    @FXML
    public HBox authPanel; //создаем верхнюю панель
    @FXML
    public TextField loginField; //создаем поле для ввода логина
    @FXML
    public PasswordField passwordField; // создаем поле для ввода порола
    @FXML
    public HBox msgPanel; // создаем нижнюю панель

    private Socket socket; // создаем сокет
    DataInputStream in; // входной поток
    DataOutputStream out; // выходной поток

    private boolean authenticated; // булева переменная отвечающая за аунтификацию
    private String nickname;
    private final String TITLE = "ГикЧат";

    /**
     * метод для переключения окошек из верхнего в нижнее после прохождения аунтификации
     *
     * @param authenticated
     */
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
        authPanel.setVisible(!authenticated); // если мы не прошли аунтификацию панель на месте
        authPanel.setManaged(!authenticated); // если мы не прошли аунтификацию панель еще и место занимает
        msgPanel.setVisible(authenticated); // если мы прошли аунтификацию панель видня нижняя панель
        msgPanel.setManaged(authenticated); // если мы прошли аунтификацию нижняя панель  занимает место

        if (!authenticated) { // если аунтификация не прошла то имя ровно null
            nickname = "";
        }
        setTitle(nickname);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) { //отвечает за инициализацию соединения после того как отрисовываются графичиские
        setAuthenticated(false);

    }

    /**
     * создаем новое соединение
     */
    private void connection() {
        try {
            socket = new Socket(IP_ADDRESS, PORT); // создаем соединение в которые подаем IP и PORT
            in = new DataInputStream(socket.getInputStream()); // входной поток мы подаем в сокет
            out = new DataOutputStream(socket.getOutputStream()); // выходной поток мы подаем в сокет



            //Делаем программу которая будет выполнять роль Путти (подключения к серверу)
            // делаем поток что бы не блочился графический интерфейс
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        // цикл аунтификации для того что бы если пользователь ошибся то можно бы было еще раз зайти
                        while (true) {
                            String str = in.readUTF();

                            if (str.startsWith("/authok")) {
                                nickname = str.split("\\s", 2)[1];
                                setAuthenticated(true); // если прошли аунтификацию то меняем картинки
                                break;
                            }
                            textArea.appendText(str + "\n"); // выводим инормацию что подключились
                        }


                        //цикл работы
                        while (true) {
                            String str = in.readUTF(); // мы хотим в бесконечном цикле получать данные из входного потока

                            if (str.equals("end")) { // если клиент ввел end  отключаеся
                                System.out.println("Клиент отключился");
                                break;
                            }
                            System.out.println("Клиент: " + str); //выводим в консоль переданное сообщение клиентом
                            textArea.appendText(str); // передом  это же сообщение в текстАрию
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("Мы отключились от сервера");
                        setAuthenticated(false); // при отключении меняем картинки на старые
                        try {
                            socket.close(); // закрываем соединения
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start(); // стартуем поток
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Создаем метод отвечающий за отправку сообщений при нажатии на кнопку
     * @param actionEvent
     */
    public void sendMsg(ActionEvent actionEvent) {
        try {
            out.writeUTF(textField.getText()); // отправим на сервер то что мы ввели
            textField.clear(); //чистка текста
            textField.requestFocus(); // вернуть фокусировку
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * метод который будет срабатывать при вводе пароля и логина в loginField и passwordField
     *
     * @param actionEvent
     */
    public void tryToAuth(ActionEvent actionEvent) {
        if (socket == null || socket.isClosed()) {
            connection(); // если сокета нету, то мы его создаем
        }
        try {
            out.writeUTF(String.format("/auth %s %s", loginField.getText().trim().toLowerCase(),  // задает формат текста который передает сервер, если логин введен с пробелами или введен капс лок, то он приводит приводит к одному формату
                    passwordField.getText().trim())); //убираются пробелы
            passwordField.clear(); //зачищаем окно пароля
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * метод для того что бы было видно кто управляет клиентом
     *
     * @param nick
     */
    private void setTitle(String nick) {   //??????
        Platform.runLater(() -> {
            ((Stage) textField.getScene().getWindow()).setTitle(TITLE + " " + nick); // утоновливает титульник и ник вверху чата
        });
    }
}

