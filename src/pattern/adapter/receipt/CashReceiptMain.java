package pattern.adapter.receipt;

public class CashReceiptMain {
    public static void main(String[] args) {
        // 기존 시스템 인스턴스 생성
        CompanyACashReceiptSystem companyA = new CompanyACashReceiptSystem();
        CompanyBCashReceiptSystem companyB = new CompanyBCashReceiptSystem();

        // Adapter를 통해 각 시스템을 표준 인터페이스에 맞춰 사용
        CashReceiptAdapter adapter1 = new CashReceiptAdapter(companyA);
        CashReceiptAdapter adapter2 = new CashReceiptAdapter(companyB);

        // 표준 인터페이스를 통해 현금영수증 발행
        adapter1.issueCashReceipt(); // 출력: Company A 형식의 현금영수증을 발행합니다.
        adapter2.issueCashReceipt(); // 출력: Company B 형식의 현금영수증을 생성합니다.
    }
}
