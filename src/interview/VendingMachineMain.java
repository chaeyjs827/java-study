package protopie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1. 자판기 클래스
class VendingMachine {
    Long id;
    String name;
    String type; // ice(냉장) | normal(일반)
    Map<Integer, Item> portItemMap = new HashMap<>(); // 포트 번호와 제품을 맵핑
    Boolean isOperated = false;
    Map<Integer, Integer> cashInventory = new HashMap<>(); // 자판기 보유 현금

    public VendingMachine(Long id, String name, String type, Boolean isOperated) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.isOperated = isOperated;
        initCashInventory();
    }

    private void initCashInventory() {
        cashInventory.put(100, 100);
        cashInventory.put(500, 50);
        cashInventory.put(1000, 50);
        cashInventory.put(5000, 10);
        cashInventory.put(10000, 10);
    }

    public boolean isOperatied() {
        return isOperated;
    }

    public void addItemToPort(int portNumber, Item item) {
        portItemMap.put(portNumber, item);
    }

    public Item selectItemByPort(int portNumber) {
        Item item = portItemMap.get(portNumber);
        if (item != null && item.stock > 0) {
            return item;
        }
        return null;
    }

    public void displayCashInventory() {
        System.out.println("자판기 보유 현금 상태:");
        for (Map.Entry<Integer, Integer> entry : cashInventory.entrySet()) {
            System.out.println(entry.getKey() + "원: " + entry.getValue() + "개");
        }
    }

    // 사용자가 자판기에 현금을 추가하는 메서드
    public void addCashToInventory(Map<Integer, Integer> paymentCash) {
        for (Map.Entry<Integer, Integer> entry : paymentCash.entrySet()) {
            int denomination = entry.getKey();
            int count = entry.getValue();
            int currentInventory = cashInventory.getOrDefault(denomination, 0);
            cashInventory.put(denomination, currentInventory + count); // 자판기의 현금 보유량 업데이트
        }
    }
}

// 2. 사용자 클래스
class User {
    Long id;
    String name;
    Payment payment;

    public User(Long id, String name, Payment payment) {
        this.id = id;
        this.name = name;
        this.payment = payment;
    }
}

// 3. 제품 클래스
class Item {
    Long id;
    String name;
    Integer price;
    Integer stock;

    public Item(Long id, String name, Integer price, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

// 4. 결제 인터페이스
interface Payment {
    boolean processPayment(int amount);
}

// 5. Cash 결제 클래스
class CashPayment implements Payment {
    private List<Cash> cashList = new ArrayList<>(); // 사용자가 가지고 있는 현금 리스트
    private Map<Integer, Integer> paymentCash = new HashMap<>(); // 실제로 지불된 금액을 기록

    public CashPayment(List<Cash> cashList) {
        this.cashList = cashList;
    }

    @Override
    public boolean processPayment(int amount) {
        int totalCash = getTotalCashAmount();
        if (totalCash >= amount) {
            if (substructCash(amount)) { // 사용자의 현금을 차감
                System.out.println("현금 결제 성공!");
                return true; // 결제 성공
            } else {
                System.out.println("현금이 부족합니다.");
                return false; // 결제 실패
            }
        } else {
            System.out.println("현금이 부족합니다.");
            return false; // 결제 실패
        }
    }

    // 사용자의 보유 현금을 소액 화폐부터 차감
    private boolean substructCash(int amount) {
        int remainingAmount = amount;
        int[] cashDenominations = {10000, 5000, 1000, 500, 100}; // 소액 화폐부터 차감
        paymentCash.clear(); // 지불된 금액 초기화

        // 필요한 만큼 차감하면서 남은 금액을 계산
        for (int denomination : cashDenominations) {
            for (Cash cash : cashList) {
                if (cash.amount >= denomination) {
                    int count = remainingAmount / denomination; // 필요한 화폐의 개수 계산
                    int actualDeduction = Math.min(count, cash.amount / denomination); // 실제로 차감 가능한 개수
                    cash.amount -= actualDeduction * denomination; // 해당 화폐에서 차감
                    remainingAmount -= actualDeduction * denomination; // 남은 금액 차감

                    paymentCash.put(denomination, paymentCash.getOrDefault(denomination, 0) + actualDeduction); // 지불된 금액 기록

                    if (remainingAmount == 0) break; // 남은 금액이 없으면 종료
                }
            }
            if (remainingAmount == 0) break; // 모든 금액이 차감되었으면 종료
        }

        return remainingAmount == 0;
    }

    // 사용자의 보유 현금 총액 계산
    public int getTotalCashAmount() {
        int total = 0;
        for (Cash cash : cashList) {
            total += cash.amount;
        }
        return total;
    }

    // 자판기에 지불된 현금 정보를 반환하는 메서드
    public Map<Integer, Integer> getPaymentCash() {
        return paymentCash;
    }
}

// 6. 카드 결제 클래스(결제 인터페이스 구현체)
class CardPayment implements Payment {
    private int cardLimit;

    public CardPayment(int cardLimit) {
        this.cardLimit = cardLimit;
    }

    @Override
    public boolean processPayment(int amount) {
        if (cardLimit >= amount) {
            cardLimit -= amount;
            System.out.println("카드 결제 성공!");
            return true;
        } else {
            System.out.println("카드 한도가 부족합니다.");
            return false;
        }
    }
}

// 7. 현금 클래스(결제 인터페이스 구현체)
class Cash {
    String name;
    Integer amount;

    public Cash(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }
}

public class VendingMachinMain {
    public static void main(String[] args) {
        // 자판기 생성
        VendingMachine vendingMachine = new VendingMachine(1L, "냉장 자판기 1호", "ice", true);

        // 제품 추가 (포트 번호와 제품을 맵핑)
        Item coke = new Item(1L, "콜라", 1100, 10);
        Item water = new Item(2L, "물", 600, 10);
        Item coffee = new Item(3L, "커피", 700, 10);
        vendingMachine.addItemToPort(101, coke);    // 101 port에 콜라 진열
        vendingMachine.addItemToPort(102, water);   // 102 port에 물 진열
        vendingMachine.addItemToPort(103, coffee);  // 103 port에 커피 진열

        // 현금 사용자 생성 및 결제 방법 설정 (현금 결제)
        List<Cash> cashList = new ArrayList<>();
        cashList.add(new Cash("10,000원", 10000));
        cashList.add(new Cash("500원", 500));
        cashList.add(new Cash("100원", 100));

        User cashUser = new User(1L, "현금구매자", new CashPayment(cashList));

        // 카드 사용자 생성 및 결제 방법 설정 (카드 결제)
        User cardUser = new User(2L, "카드구매자", new CardPayment(5000)); // 카드 한도 5000원

        // 자판기 운영 여부 확인
        if (!vendingMachine.isOperatied()) {
            System.out.println("자판기 미운영 중");
            return;
        }

        // 현금 결제 테스트
        System.out.println("=== 현금 사용자 테스트 ===");
        processVendingMachinePurchase(cashUser, vendingMachine, 101); // 포트 101 선택 (콜라)

        System.out.println("\n\n[현금 결제 후 자판기 현금 보유 상태 출력]");
        vendingMachine.displayCashInventory();

        // 카드 결제 테스트
        System.out.println("\n=== 카드 사용자 테스트 ===");
        processVendingMachinePurchase(cardUser, vendingMachine, 102); // 포트 102 선택 (물)

        System.out.println("\n\n[최종 자판기 현금 보유 상태 출력]");
        vendingMachine.displayCashInventory();
    }

    // 자판기 구매 처리 함수
    private static void processVendingMachinePurchase(User user, VendingMachine vendingMachine, int portNumber) {
        // 포트 번호를 통해 제품 선택
        Item selectedItem = vendingMachine.selectItemByPort(portNumber);
        if (selectedItem == null) {
            System.out.println("선택된 포트에 제품이 없거나 품절입니다.");
            return;
        }

        // 결제 진행
        if (!user.payment.processPayment(selectedItem.price)) {
            System.out.println("결제 실패.");
            return;
        }

        // 결제 성공 및 제품 배출
        System.out.println("결제 성공! 제품 배출 : " + selectedItem.name);
        selectedItem.stock -= 1; // 재고 감소

        // 결제 성공 후, 사용자가 지불한 현금을 자판기에 추가 (현금 결제의 경우에만)
        if (user.payment instanceof CashPayment) {
            CashPayment cashPayment = (CashPayment) user.payment;
            vendingMachine.addCashToInventory(cashPayment.getPaymentCash()); // 지불된 현금을 자판기에 추가
        }
    }

}
