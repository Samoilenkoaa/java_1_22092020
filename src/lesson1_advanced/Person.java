package lesson1_advanced;

public class Person implements Runnable, Jumpable {
    private final int MAX_RUN_LENGTH = 70;
    private final int JUMP = 50;
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override

    public boolean run(Treadmill treadmill) {
        System.out.println("person " + name + " run");
        if (MAX_RUN_LENGTH >= treadmill.getLength()) {
            System.out.println("person " + name + " Успешно пробеэал");
            return true;
        } else {
            System.out.println("person " + name + " Не смог пробежать");
            return false;
        }
    }
    public boolean jump(Wall wall) {
        System.out.println("person " + name + " run");
        if(JUMP >= wall.getH()) {
            System.out.println("person " + name + " Успешно прыгнул");
            return true;
        } else {
            System.out.println("person " + name + " Не смог прыгнуть");
            return false;
        }
    }


}
