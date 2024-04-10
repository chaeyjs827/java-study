package inflearn.chapter10.polymorphism.polyabstract.ex1;

public class Ex1Cow extends AbstractAnimal {
    @Override
    public void sound() {
        System.out.println("음메");
    }

    @Override
    public void move() {
        System.out.println("음메 이동");
    }
}
