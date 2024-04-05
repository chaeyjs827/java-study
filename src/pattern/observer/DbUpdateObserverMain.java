package pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class DbUpdateObserverMain {

    public static void main(String[] args) {
        ProductUpdate productUpdate = new ProductUpdate();
        CacheObserver cacheObserver = new CacheObserver();
        MemoObserver memoObserver = new MemoObserver();

        // 옵저버 등록
        productUpdate.registerObserver(cacheObserver);
        productUpdate.registerObserver(memoObserver);

        // product 업데이트
        productUpdate.updateProduct(123);
    }

}

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void doObserver(int productId);
}

interface Observer {
    void update(int productId);
}

class ProductUpdate implements Subject {

    private List<Observer> observerList = new ArrayList<>();

    public void updateProduct(int productId) {
        // 테이블 업데이트 로직

        // 업데이트 후 어드민 메모 작성
        doObserver(productId);
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void doObserver(int productId) {
        for (Observer observer : observerList) {
            observer.update(productId);
        }
    }
}

class CacheObserver implements Observer {

    @Override
    public void update(int productId) {
        System.out.println("캐시 삭제 로직 실행 productId : " + productId);
    }
}

class MemoObserver implements Observer {

    @Override
    public void update(int productId) {
        System.out.println("상품 정보 변경 메모 작성 productId : " + productId);
    }
}
