package inflearn.chapter10.polymorphism.ex2;

public class Cow implements InterfaceAnimal {
    @Override
    public void sound() {
        System.out.println("음메");
    }

    @Override
    public void move() {
        System.out.println("음메 움직인다.");
    }

    @Override
    public void sleep() {
        System.out.println("음메 잔다.");
    }
}
