package lesson6;

public class Cat extends Animal {
    private final int MAX_RUN_LENGTH = 200;


    public Cat(String name) {
        super(name);
        count2++;

    }

    @Override
    public void run(int length) {
        if(length >=0 && length <= MAX_RUN_LENGTH) {
            System.out.println(name + " успешно пробежал " + length + " метров");
        } else {
            System.out.println(name + " не смог пробежать " + length + " метров");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println(name + " не умеет плавать");
    }

    @Override
    public  void printCount() {
        System.out.println("Количество котов " + count2);
    }
}
