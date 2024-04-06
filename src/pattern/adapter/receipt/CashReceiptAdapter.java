package pattern.adapter.receipt;

public class CashReceiptAdapter implements CacheReceiptSystem
{
    private CompanyACashReceiptSystem companyA;
    private CompanyBCashReceiptSystem companyB;

    public CashReceiptAdapter(CompanyACashReceiptSystem companyA) {
        this.companyA = companyA;
    }

    public CashReceiptAdapter(CompanyBCashReceiptSystem companyB) {
        this.companyB = companyB;
    }

    @Override
    public void issueCashReceipt() {
        if (companyA != null) {
            companyA.generateReceipt();
        } else if (companyB != null) {
            companyB.createReceipt();
        }
    }
}
