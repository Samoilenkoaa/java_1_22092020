package lesson1_advanced;

public class Cat implements Runnable, Jumpable {
    private final int MAX_RUN_LENGTH = 50;
    private final int JUMP = 40;

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public boolean run(Treadmill treadmill) {
        System.out.println("cat " + name + " run");
        if(MAX_RUN_LENGTH >= treadmill.getLength()) {
            System.out.println("cat " + name + " Успешно пробеэал");
            return true;
        } else {
            System.out.println("Cat " + name + " Не смог пробежать");
            return false;
        }
    }
    public boolean jump(Wall wall) {
        System.out.println("cat " + name + " run");
        if(JUMP >= wall.getH()) {
            System.out.println("cat " + name + " Успешно прыгнул");
            return true;
        } else {
            System.out.println("Cat " + name + " Не смог прыгнуть");
            return false;
        }
    }

}
