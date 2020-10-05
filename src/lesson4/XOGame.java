package lesson4;

import java.util.Random;
import java.util.Scanner;

public class XOGame {

    static final int SIZE = 5;      // размер нашего поля
    static final int DOTS_TO_WIN = 4; // количество точек победы
    static final char DOT_X = 'X';  // создали переменную которая отвечает за ход Х
    static final char DOT_0 = '0'; // создали переменную которая отвечает за ход 0
    static final char DOT_EMPTY = '.'; // создали переменную которая отвечает за свободное место на игровом поле

    static char[][] map; //создали массив в ктором будем хранить наше игровое поле

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random(); // создаем рандом для произвольного ходя компа

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (chekWin(DOT_X)) {
                System.out.println("Вы победитель!");
                break;
            }
            if (isFull()) {    // проверка на ничью
                System.out.println("Ничья!");
                break;
            }

            aiTurn();
            printMap();
            if (chekWin(DOT_X)) {
                System.out.println("Компьютер победил");
                break;
            }


            if (isFull()) {  // проверка на ничью
                System.out.println("Ничья!");
                break;
            }
        }
    }

    static void initMap() { // создаем метод инициализации нашей карты и заполнением его свободными местами
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }

        }

    }

    static void printMap() { // создаем метод распечатки нашей карты
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println(" ");

        }
    }

    static void humanTurn() { //создаем метод кторый отвечает за ход человека
        int x; // создали переменные координаты
        int y;
        do
        {                                               // будет крутиться пока человек не введет нормальные координаты
            System.out.println("Введите координаты X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCallValid(y, x));

        map[y][x] = DOT_X;     // ход человека

    }

    static void aiTurn() { //создаем метод кторый отвечает за ход компа
        int x; // создали переменные координаты
        int y;
        boolean found = false;
        for (int i = 0; i < SIZE; i++) {         // создаем интелект компа
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = DOT_X;
                    if (chekWin(DOT_X)) {
                        found = true;
                        map[i][j] = DOT_0;
                        break;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
            if (found) break;
        }

        if (!found) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCallValid(y, x));

            map[y][x] = DOT_0;     // ход человека
        }
    }


    static boolean isCallValid(int y, int x) { // создаем метод который будет проверяять валидна ли ячейка
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY; // проверяем свободля ли ячейка
    }

    static boolean isFull() { // метод для проверки на ничью
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }

        }
        return true;
    }

    static boolean chekWin(char c) { // метод на проверку победы
        int counter = 0; // счетчик для подсчета победной серии по горизоньали
        for (int i = 0; i < SIZE; i++) { // переменная i отвечает за переход по вертикали
            for (int j = 0; j < SIZE; j++) { // переменная j отвечает за X которая увеличивается
                if (map[i][j] == c) counter++;
                else counter = 0;
                if (counter >= DOTS_TO_WIN) {
                    return true;
                }
            }
            counter = 0;
        }

        for (int i = 0; i < SIZE; i++) {    // проверка по вертикали, переменная i отвечает за X
            for (int j = 0; j < SIZE; j++) {  // переменная j отвечает за Y вертикаль
                if (map[j][i] == c) counter++;
                else counter = 0;
                if (counter >= DOTS_TO_WIN) {
                    return true;
                }
            }
            counter = 0;

        }

        for (int i = 0; i < SIZE; i++) {  // проверка по диагонали 1
            if (map[i][i] == c) counter++;
            else counter = 0;
            if (counter >= DOTS_TO_WIN) {
                return true;
            }
        }
        counter = 0;


        for (int i = 0; i < SIZE; i++) {  // проверка диагонали 2
            if (map[4 - i][i] == c) counter++;
            else counter = 0;
            if (counter >= DOTS_TO_WIN) {
                return true;
            }
        }
        counter = 0;

        // Проверка побочных диагоналей
        int counter2 = 0;
        for (int i = 0; i < SIZE-1; i++) {
            if(map[i+1][i] == c){
                counter ++;
            }
            if(map[i][i+1] == c){
                counter2 ++;
            }
            if (counter == DOTS_TO_WIN || counter2 == DOTS_TO_WIN){
                return true;
            }
        }
        counter =0;
        counter2 =0;

        // Проверка обратных диагоналей
        for (int i = 0; i < SIZE-1; i++) {
            if(map[3-i][i] == c){
                counter ++;
            }
            if(map[4-i][i+1] == c){
                counter2 ++;
            }

            if (counter == DOTS_TO_WIN || counter2 == DOTS_TO_WIN){
                return true;
            }
        }

        return false;

    }

}
