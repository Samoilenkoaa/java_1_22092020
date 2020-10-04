package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
// ЗАДАЧА № 1
//        Scanner scanner = new Scanner(System.in);
//        Random random = new Random();
//        int guess, number;
//        number = random.nextInt(9);
//        do {
//            for (int i = 3; i > 0; i--) {
//                System.out.println("Введи число от 0 до 9");
//                guess = scanner.nextInt();
//
//                if (number == guess) {
//                System.out.println("Поздравляю, вы угадали!");
//                break;
//                }else if (number > guess) {
//                    System.out.println("Вы ввели слишком маленькое число");
//                    System.out.println("У вас осталось " + (i - 1) + " попыток");
//                }else if (number < guess) {
//                    System.out.println("Вы ввели слишком большое число");
//                    System.out.println("У вас осталось " + (i - 1) + " попыток");
//                }if (i - 1 == 0) {
//                    System.out.println("Вы проиграли. Правильный ответ " + number);
//                }
//            }
//            System.out.println("Повторить игру? 1 - да, 0 - нет");
//        }while (scanner.nextInt() == 1);
// ЗАДАЧА № 2
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
                "potato"};
        String guess = getRandomWord(words);
        String maskedGuess = maskWord(guess);
        System.out.println("Guess the word");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String myWord = br.readLine();
            myWord = maskWord(myWord);
            if (maskedGuess.equals(myWord)) {
                System.out.println("You win! The word is: " + guess);
                break;
            } else {
                String maskedResult = "";
                for (int i = 0; i < maskedGuess.length() - 1; i++) {
                    if (maskedGuess.charAt(i) == myWord.charAt(i)) maskedResult += maskedGuess.charAt(i);
                    else maskedResult += "#";
                }
                System.out.println(maskedResult);
                System.out.println("WRONG! Try again!");
            }
        }

    }

    static String getRandomWord(String[] s) {
        Random r = new Random();
        return s[r.nextInt(s.length - 1)];
    }

    static String maskWord(String s) {
        String mask = "###############";
        for (int i = s.length() - 1; i < mask.length() - 1; i++) {
            s += mask.charAt(i);
        }
        return s;
    }
}

