package lesson6;

public class Animal {
    private final int MAX_RUN_LENGTH = 0;
    private final int MAX_SWIM_LENGTH = 0;
    String name;
    int run;
    int swim;
    static int count1 = 0;
    static int count2 = 0;
    static int count3 = 0;


    public Animal(String name) {
        this.name = name;
        count1++;

    }

    public void run(int length) {


    }

    public void swim(int length) {

    }
    public  void printCount() {
        System.out.println("Количество животных " + count1);
    }

    public static int getCount1() {
        System.out.println("Количество животных " + count1);
        return count1;
    }

}
