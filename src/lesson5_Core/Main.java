package lesson5_Core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        ExecutorService service = Executors.newFixedThreadPool(CARS_COUNT);


        Race race = new Race(new Road(60), new Tunnel(), new Road(40));

        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < CARS_COUNT; i++) {
            cars.add(new Car(race, 20 + (int) (Math.random() * 10)));
        }
//        for (int i = 0; i < cars.length; i++) {
//            new Thread(cars[i]).start();
//        }
        ArrayList<Callable<String>> carsСontinuation  = new ArrayList<>();
        List<Future<Callable>> result = service.invokeAll(cars);
        for (int i = 0; i < result.size(); i++) {
            try {
                carsСontinuation.add(result.get(i).get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        service = Executors.newFixedThreadPool(CARS_COUNT);

        List<Future<String>> result2 = service.invokeAll(carsСontinuation);
        service.shutdown();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");




    }
}
