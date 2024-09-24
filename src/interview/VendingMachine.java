import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// 1. 자판기 클래스
class VendingMachine {
    Long id;
    String name;
    String type; // ice(냉장) | normal(일반)
    List<Item> items = new ArrayList<>();
    int cashAmount; // 자판기에 보유한 현금 총액

    public VendingMachine(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public boolean isOperating() {
        // 자판기 운영 여부 체크 로직
        return true; // true면 운영 중
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item selectItem(Long itemId) {
        for (Item item : items) {
            if (item.id.equals(itemId) && item.stock > 0) {
                return item;
            }
        }
        return null; // 품절 또는 잘못된 번호 선택 시
    }
}

// 2. 사용자 클래스
class User {
    Long id;
    String name;
    Payment payment; // 인터페이스 사용

    public User(Long id, String name, Payment payment) {
        this.id = id;
        this.name = name;
        this.payment = payment;
    }
}

// 3. 제품(Item) 클래스
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

// 4. 에러 로그 클래스
class VendingMachineErrorLog {
    Long vendingMachineId;
    LocalDateTime createDate;

    public VendingMachineErrorLog(Long vendingMachineId, LocalDateTime createDate) {
        this.vendingMachineId = vendingMachineId;
        this.createDate = createDate;
    }
}

// 5. 판매 성공 로그 클래스
class VendingMachineSuccessLog {
    Long vendingMachineId;
    LocalDateTime createDate;

    public VendingMachineSuccessLog(Long vendingMachineId, LocalDateTime createDate) {
        this.vendingMachineId = vendingMachineId;
        this.createDate = createDate;
    }
}

// 6. 현금 클래스
class Cash {
    String name; // 화폐 이름 ex: 5,000원
    Integer amount; // 화폐 단위 ex: 5000

    public Cash(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }
}

// 7. Payment 인터페이스
interface Payment {
    boolean processPayment(int amount);
}

// 8. Cash 결제 클래스
class CashPayment implements Payment {
    private int userCashAmount;
    private List<Cash> cashList = new ArrayList<>();

    public CashPayment(int userCashAmount) {
        this.userCashAmount = userCashAmount;
    }

    @Override
    public boolean processPayment(int amount) {
        if (userCashAmount >= amount) {
            userCashAmount -= amount;
            return true; // 결제 성공
        } else {
            return false; // 잔액 부족
        }
    }

    public int getChange(int amount) {
        // 잔돈 계산 로직
        return userCashAmount - amount;
    }
}

// 9. Card 결제 클래스
class CardPayment implements Payment {
    private int cardLimit;

    public CardPayment(int cardLimit) {
        this.cardLimit = cardLimit;
    }

    @Override
    public boolean processPayment(int amount) {
        if (cardLimit >= amount) {
            cardLimit -= amount;
            return true; // 결제 성공
        } else {
            return false; // 한도 초과
        }
    }
}

// 10. 자판기 로직 처리
public class VendingMachineSystem {
    public static void main(String[] args) {
        // 자판기 생성
        VendingMachine vendingMachine = new VendingMachine(1L, "자판기 1호", "ice");

        // 제품 추가
        Item coke = new Item(1L, "Coke", 1500, 10);
        Item water = new Item(2L, "Water", 1000, 0); // 품절 상태
        vendingMachine.addItem(coke);
        vendingMachine.addItem(water);

        // 사용자 생성 및 결제 방법 설정
        User user = new User(1L, "Jun", new CashPayment(5000)); // 현금 5000원 소지

        // 자판기 운영 여부 확인
        if (!vendingMachine.isOperating()) {
            System.out.println("자판기 미운영 중");
            return;
        }

        // 제품 선택
        Item selectedItem = vendingMachine.selectItem(1L); // Coke 선택
        if (selectedItem == null) {
            System.out.println("선택된 제품이 없거나 품절입니다.");
            return;
        }

        // 결제 진행
        boolean paymentSuccess = user.payment.processPayment(selectedItem.price);
        if (!paymentSuccess) {
            System.out.println("결제 실패. 잔액 또는 한도 부족.");
            return;
        }

        // 결제 성공 및 제품 배출
        System.out.println("결제 성공! 제품 배출 중: " + selectedItem.name);
    }
}