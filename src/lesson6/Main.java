package lesson6;

public class Main {
    public static void main(String[] args) {


        Animal[] animals = {
                new Cat("Barsik"),
                new Dog("Spike")
        };
        for (int i = 0; i < animals.length; i++) {
            animals[i].run(305);
            animals[i].swim(5);
            animals[i].printCount();
        }
        Animal.getCount1();

    }
}
