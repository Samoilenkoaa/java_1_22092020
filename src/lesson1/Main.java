package lesson1;

public class Main {

    public static void main(String[] args) {
        String a = "Hello";
        byte b = 48;
        short c = 250;
        int d = 1000;
        long l = 5467489L;
        float f = 4.67589f;
        double g = 6.4568945;
        char ch = 'b';
        boolean bo = true;

        System.out.println(calculation(3.456f, 5.457f, 4.456f, 8.543f));
        System.out.println(sumAB(5, 6));
        printPositive(4);
        System.out.println(negative(-3));
        printName("Леша");
        printYears(2020);

    }
    static float calculation (float a, float b, float c, float d) {
        return a * (b + (c / d));
    }
    static  boolean sumAB(int a, int b) {
        int c = a + b;
        if(c >= 10 && c <= 20) {
            return true;

        } else {
            return false;
        }
    }
    static void printPositive(int v) {
        if(v >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }
    static boolean negative (int g) {
        if(g < 0) {
            return true;
        } else {
            return false;
        }
    }
    static void printName(String name) {
        System.out.println("Привет " + name + "!");

    }
    static void printYears(int number) {
        if(number % 400 == 0) {
            System.out.println("Високосный");
        }
        else if(number % 100 == 0) {
            System.out.println("Не високосный");
        }
        else if(number % 4 == 0) {
            System.out.println("Високосный");
        }
        else {
            System.out.println("Не високосный");
        }

    }
}
