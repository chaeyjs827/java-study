package pattern.factory.pay1;

public class AlmondPay implements FacPayment {
    @Override
    public void pay() {
        System.out.println("아몬트 페이 결제 로직 실행");
    }
}