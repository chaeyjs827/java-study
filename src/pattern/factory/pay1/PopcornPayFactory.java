package pattern.factory.pay1;

public class PopcornPayFactory implements FacPaymentFactory{
    @Override
    public FacPayment createPayment() {
        return new PopcornPay();
    }
}
