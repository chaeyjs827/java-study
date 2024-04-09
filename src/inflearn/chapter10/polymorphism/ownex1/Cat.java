package inflearn.chapter10.polymorphism.ownex1;

public class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("냐옹");
    }
}