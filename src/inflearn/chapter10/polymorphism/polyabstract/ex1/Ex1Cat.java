package inflearn.chapter10.polymorphism.polyabstract.ex1;

public class Ex1Cat extends AbstractAnimal {
    @Override
    public void sound() {
        System.out.println("냐옹");
    }

    @Override
    public void move() {
        System.out.println("냐옹 이동");
    }
}
