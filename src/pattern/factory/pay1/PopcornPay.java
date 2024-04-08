package pattern.factory.pay1;

public class PopcornPay implements FacPayment {
    @Override
    public void pay() {
        System.out.println("팝콘 페이 결제 로직 실행");
    }
}
