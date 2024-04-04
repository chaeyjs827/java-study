package pattern.observer.notify;

public class AdminMemoObserver implements Observer {
    @Override
    public void update(int userId) {
        System.out.println("Admin 메모 메소드 실행 => userId : " + userId);
    }
}
