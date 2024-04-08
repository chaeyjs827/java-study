package pattern.factory.pay1;

public class NutsPaymentEx1Main {

    /**
     * Factory Method 패턴은 객체 생성에 관한 디자인 패턴 중 하나입니다.
     * 이 패턴은 객체를 생성하기 위한 인터페이스를 정의하고, 이를 서브클래스에서 결정하는 패턴입니다.
     * 이는 객체를 생성하는 방식을 추상화하여, 클라이언트 코드가 구체적인 클래스에 대한 의존성을 줄이고, 유연성을 높이는 데 도움이 됩니다.
     *
     * @param args
     */

    public static void main(String[] args) {
        FacPaymentFactory almondPayFactory = new AlmondPayFactory();
        FacPayment almondPay = almondPayFactory.createPayment();
        almondPay.pay();

        FacPaymentFactory popcornPayFactory = new PopcornPayFactory();
        FacPayment popcornPay = popcornPayFactory.createPayment();
        popcornPay.pay();
    }

}
