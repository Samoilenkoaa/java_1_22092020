package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void addFood(int food) {
        this.food += food;
        System.out.println("В тарелке стало корма " + this.food);
    }

    public boolean eatFood(int foodEated){
        if(food < foodEated) {
            return false;
        } else {
            food = food - foodEated;
            return true;
        }

    }
}
