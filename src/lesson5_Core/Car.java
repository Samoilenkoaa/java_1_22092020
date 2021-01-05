package lesson5_Core;

import java.util.concurrent.Callable;

public class Car implements Callable<Callable> {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    Callable<String> callable = new Callable() {
        @Override
        public String call() throws Exception {
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(Car.this);
            }
            synchronized(race.win){
            if(race.win.booleanValue() == false) {
                System.out.println(Car.this.name + "win");
                race.win = true;
            }
            }
            return "";
        }
    };

    @Override
    public Callable call() throws Exception {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return callable;

    }
}


