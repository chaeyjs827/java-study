package inflearn.chapter10.polymorphism.ex2;

public class Dog implements InterfaceAnimal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }

    @Override
    public void move() {
        System.out.println("멍멍 움직인다.");
    }

    @Override
    public void sleep() {
        System.out.println("멍멍 잔다.");
    }
}
