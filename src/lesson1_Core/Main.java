package lesson1_Core;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //TASK 1
        Integer arr1[] = {1, 2, 3, 4, 5, 6, 7};
        String arr2[] = {"A", "B", "C", "D"};
        swap(arr1, 1, 4);
        swap(arr2, 0, 2);

        //TASK 2
        String[] arrayOfStrings = {"A", "B", "C", "D"};
        ArrayList list1 = asList(arrayOfStrings);

        //TASK 3
        Box<Apple> box = new Box();
        Box<Orange> box2 = new Box();
        Box<Apple> box3 = new Box();
        Apple apple = new Apple();
        Orange orange = new Orange();
        box.addFruit(apple);
        box2.addFruit(orange);
        box3.addFruit(new Apple());
        System.out.println(box.compare(box2));
        System.out.println(box.pourItOver(box3));

        System.out.println(box.getWeight());
        System.out.println(box2.getWeight());
        System.out.println(box3.getWeight());


    }


    public static void swap(Object[] arr, int n1, int n2) {
        System.out.println("Task1: " + Arrays.toString(arr));
        Object sw = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = sw;
        System.out.println("The result of the replacement: " + Arrays.toString(arr) + "\n================================");
    }



        public static <T> ArrayList<T> asList(T[]arr) {
            ArrayList<T> alt = new ArrayList<>(Arrays.asList(arr));
            System.out.println("Task2 and the result of the conversion : " + alt + "\n================================");
            return alt;
        }
}
