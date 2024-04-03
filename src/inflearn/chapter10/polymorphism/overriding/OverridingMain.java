package inflearn.chapter10.polymorphism.overriding;

public class OverridingMain {

    public static void main(String[] args) {
        System.out.println("=========================");
        // 자식 변수가 자식 인스턴스 참조
        Child child = new Child();
        System.out.println("Child -> Child");
        System.out.println("value = " + child.value);
        child.method();

        System.out.println("=========================");

        // 부모 변수가 부모 인스턴스 참조
        Parent parent = new Parent();
        System.out.println("Parent -> Parent");
        System.out.println(parent.value);
        parent.method();

        System.out.println("=========================");
        //  부모 변수가 자식 인스턴스 참조(다형적 참조)
        Parent poly = new Child();
        System.out.println("Parent -> Child");
        System.out.println(poly.value); // 변수는 오버라이딩이 안된다.
        poly.method();                  // 메소드는 오버라이딩이 된다.

        // 오버라이딩 된 메서드는 항상 우선권을 갖는다 !! 그렇기 때문에 Parent 의 method 가 아닌 Child의 method를 갖는다.

        System.out.println("=========================");

    }

}
