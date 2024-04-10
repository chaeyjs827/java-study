package inflearn.chapter10.polymorphism.diamond;

public class ChildInterface implements InterfaceA, InterfaceB {
    @Override
    public void a() {
        System.out.println("나는 InterfaceA 메소드에용");
    }

    @Override
    public void b() {
        System.out.println("나는 InterfaceB 메소드에용");
    }

    @Override
    public void commonMethod() {
        System.out.println("나는 누구건지 모르겠지? 어쨌든 A,B 둘 중하나인데 내 스스로 구현하기 때문에 모호성을 극복했다.");
    }
}
