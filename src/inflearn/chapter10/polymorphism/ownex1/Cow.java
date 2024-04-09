package inflearn.chapter10.polymorphism.ownex1;

public class Cow implements Animal {
    @Override
    public void sound() {
        System.out.println("음메");
    }
}
