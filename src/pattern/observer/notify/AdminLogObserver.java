package pattern.observer.notify;

public class AdminLogObserver  implements Observer {
    @Override
    public void update(int userId) {
        System.out.println("Admin 로깅 메소드 실행 => userId : " + userId);
    }
}

