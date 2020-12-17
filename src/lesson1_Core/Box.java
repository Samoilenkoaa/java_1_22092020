package lesson1_Core;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    ArrayList<T> list;

    public Box() {
        this.list = new ArrayList<T>();
    }

    public float getWeight() {
        if(list.size() > 0) {
            if(list.get(0) instanceof Orange) {
                return list.size() * 1.5f;
            } else {
                return list.size() * 1f;
            }
        }
        return 0f;

    }

    public boolean compare(Box box2) {
        return getWeight() == box2.getWeight();

    }

    public boolean addFruit(T fruit) {
       return list.add(fruit);
    }

    public boolean pourItOver(Box<T> box2) {

        boolean rezult = list.addAll(box2.list);
        box2.list.clear();
        return rezult;

    }



}
