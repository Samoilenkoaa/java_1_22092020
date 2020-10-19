package lesson7;

public class Cat {
    private String name;
    private boolean satiety;



    public Cat(String name) {
        this.name = name;
        satiety = false;
    }

    public String getName() {
        return name;
    }
     public  void  eat(Plate plate, int food) {
         System.out.println("Cat " + name + " eat");
         satiety = plate.eatFood(food);
     }

    public String isSatiety() {
        if (satiety) return "сытый";
        else return "голодный";
    }
}
