package lesson6;

public class Dog extends Animal{
    private final int MAX_RUN_LENGTH = 500;
    private final int MAX_SWIM_LENGTH = 10;

    public Dog(String name) {
        super(name);
        count3++;

    }


    @Override
    public void run(int length) {
        if(length >= 0 && length <=MAX_RUN_LENGTH) {
            System.out.println(name + " успешно пробежал " + length + " метров");
        } else {
            System.out.println(name + " не смог пробежать " + length + " метров");
        }
    }

    @Override
    public void swim(int length) {
        if(length >= 0 && length <=MAX_SWIM_LENGTH) {
            System.out.println(name + " успешно проплыл " + length + " метров");
        } else {
            System.out.println(name + " не смог проплыть " + length + " метров");
        }
    }

    @Override
    public  void printCount() {
        System.out.println("Количество собак " + count3);
    }
}
