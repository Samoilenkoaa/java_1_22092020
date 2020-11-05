package lesson1_advanced;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Treadmill treadmill = new Treadmill(55);
        Wall wall = new Wall(45);

        Object[] objects = {
                treadmill,
                wall
        };

        Cat cat = new Cat("Murzik");
        Person person = new Person("Bob");
        Robot robot = new Robot("John");
        ArrayList<Object> list = new ArrayList<>(Arrays.asList(
                cat,
                person,
                robot
        ));

        for(Object x : objects) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()){
                Object u = iterator.next();
                if(x instanceof Treadmill) {
                    Runnable runnable = (Runnable) u;
//                    runnable.run((Treadmill) x);
                    if (!runnable.run((Treadmill)x)){
                        iterator.remove();
                    }
                }
                else if(x instanceof Wall) {
                    Jumpable jumpable = (Jumpable) u;
                    jumpable.jump((Wall) x);
                }
            }
        }

//          cat.run(treadmill);
////        person.run(treadmill);
////        robot.run(treadmill);
////        cat.jump(wall);
////        person.jump(wall);
////        robot.jump(wall);


    }
}
