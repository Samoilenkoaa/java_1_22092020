package lesson4_Calculator;

public class Сalculator {
    long num1 = 0;
    String operation;
    long num2 = 0;


    public long calculate() {
        long rezult = 0;
        if(operation != null) {
            switch (operation) {
                case "+":
                    rezult = num1 + num2;
                    break;
                case "-":
                    rezult = num1 - num2;
                    break;
                case "*":
                    rezult = num1 * num2;
                    break;
                case "/":
                    if(num2 != 0) {
                        rezult = num1 / num2;
                    }
            }
        }
        return rezult;
    }


    public void clear() {
        num1 = 0;
        num2 = 0;
        operation = null;
    }
}
