public class Main {
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        int c = 4;
        if(a < b + c) {
            System.out.println("треугольник существует");
        } else if(b < a + c) {
            System.out.println("треугольник существует");
        } else if(c < a + b) {
            System.out.println("треугольник существует");
        } else {
            System.out.println("треугольник не существует");
        }

    }
}
