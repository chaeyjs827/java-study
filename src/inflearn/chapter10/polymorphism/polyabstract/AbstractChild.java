package inflearn.chapter10.polymorphism.polyabstract;

public class AbstractChild extends AbstractParent {
    @Override
    public void abstractMethod() {
        // 추상 클래스에서 선언된 추상 메소드는 꼭 구현해야 합니다.
    }

    @Override
    public void method() {
        // 일반 메소드는 필요 시 오버라이딩 할 수 있습니다.
        System.out.println("overriding method");
    }
}
