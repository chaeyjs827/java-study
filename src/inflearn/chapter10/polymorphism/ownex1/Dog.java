package inflearn.chapter10.polymorphism.ownex1;

public class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}
