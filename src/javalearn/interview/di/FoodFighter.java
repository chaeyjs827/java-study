package javalearn.interview.di;

public class FoodFighter {

    private final Chef chef;

    public FoodFighter(Chef chef) {
        this.chef = chef;
    }

    public void eat() {
        Food food = orderFood();
        System.out.println(food.getName() + " 먹었슴다.");
    }

    private Food orderFood() {
        Food food = chef.cook();
        return food;
    }
}
