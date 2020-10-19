package lesson7;

public class Main {
    public static void main(String[] args) {
       Cat cat = new Cat("Barsik");
       Plate plate = new Plate(100);

       Cat[] cats = new Cat[3];
       cats[0] = cat;
       cats[1] = new Cat("Murzik");
       cats[2] = new Cat("Tomas");

       for (Cat cat1:cats) cat1.eat(plate, 40);
       for (Cat cat1:cats) System.out.println(cat1.getName() + " " + cat1.isSatiety());

       plate.addFood(30);





    }
}
