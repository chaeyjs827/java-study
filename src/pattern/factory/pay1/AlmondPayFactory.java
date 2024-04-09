package pattern.factory.pay1;

public class AlmondPayFactory implements FacPaymentFactory{
    @Override
    public FacPayment createPayment() {
        return new AlmondPay();
    }
}
