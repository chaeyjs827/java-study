package inflearn.chapter10.polymorphism.ex2;

public class Cat  implements InterfaceAnimal {
    @Override
    public void sound() {
        System.out.println("야옹");
    }

    @Override
    public void move() {
        System.out.println("야옹 움직인다.");
    }

    @Override
    public void sleep() {
        System.out.println("야옹 잔다.");
    }
}