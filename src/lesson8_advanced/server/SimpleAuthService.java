package lesson8_advanced.server;

import java.util.ArrayList;
import java.util.List;

// клас Простой Сервис Аутентификации
public class SimpleAuthService implements AuthService {

    /**
     * класс в котором есть логин, пароль и никнейм
     */
    private class UserData{
        String login;
        String password;
        String nickname;

        public UserData(String login, String password, String nickname) { // конструктор для класса выше
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }
    }

    List<UserData> users; //список наших юзеров

    public SimpleAuthService(){  // метод для того что бы заполнить его юзерами
        users = new ArrayList<>(); // создадим объект юзер
        for (int i = 0; i < 10; i++) { // пробигаемся по списку и добавляем новых
            users.add(new UserData("login" + i, "pass" + i, "nick" + i));
        }
        // для быстрого тестирования создадим эти 3 юзера
        users.add(new UserData("qwe", "qwe", "qwe"));
        users.add(new UserData("asd", "asd", "asd"));
        users.add(new UserData("zxc", "zxc", "zxc"));
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) { // имплеминтация интерфейса
        for (UserData user: users) {  // пробежимся по списку наших юзеров
            if (user.login.equals(login) && user.password.equals(password)){  // если есть совпадение по логину и паролю то вернем никнейм
                return user.nickname;
            }
        }
        return null; // если не нашли совпадение то возвращаеи null
    }

    /**
     * метод регистрации клиентов
     * @param login
     * @param password
     * @param nickname
     * @return
     */
    @Override
    public boolean registration(String login, String password, String nickname) {
        for (UserData user : users){
            if(user.login.equals(login) || user.nickname.equals(nickname)){ //если есть такой логина, то выходим
                return false;
            }
        }
        users.add(new UserData(login, password, nickname)); //если нет такого логина, то добавляем
        return true;
    }
}

