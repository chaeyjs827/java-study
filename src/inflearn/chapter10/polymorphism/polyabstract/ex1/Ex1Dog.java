package inflearn.chapter10.polymorphism.polyabstract.ex1;

public class Ex1Dog extends AbstractAnimal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }

    @Override
    public void move() {
        System.out.println("멍멍 이동");
    }
}
