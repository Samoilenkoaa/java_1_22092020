package lesson1_advanced;

public class Robot implements Runnable, Jumpable{
    private final int MAX_RUN_LENGTH = 40;
    private final int JUMP = 70;
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public boolean run(Treadmill treadmill) {
        System.out.println("robot " + name + " run");
        if(MAX_RUN_LENGTH >= treadmill.getLength()) {
            System.out.println("robot " + name + " Успешно пробеэал");
            return true;
        } else {
            System.out.println("robot " + name + " Не смог пробежать");
            return false;
        }
    }
    public boolean jump(Wall wall) {
        System.out.println("robot " + name + " run");
        if(JUMP >= wall.getH()) {
            System.out.println("robot " + name + " Успешно прыгнул");
            return true;
        } else {
            System.out.println("robot " + name + " Не смог прыгнуть");
            return false;
        }
    }

}
