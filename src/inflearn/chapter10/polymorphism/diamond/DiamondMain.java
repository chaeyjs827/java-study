package inflearn.chapter10.polymorphism.diamond;

public class DiamondMain {

    public static void main(String[] args) {
        InterfaceA interfaceA = new ChildInterface();
        InterfaceB interfaceB = new ChildInterface();

        interfaceA.a();
        interfaceA.commonMethod();
        interfaceB.b();
        interfaceB.commonMethod();
    }

}
