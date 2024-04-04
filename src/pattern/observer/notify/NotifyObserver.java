package pattern.observer.notify;

public class NotifyObserver implements Observer {
    @Override
    public void update(int userId) {
        System.out.println("알람 메소드 실행 => userId : " + userId);
    }
}
