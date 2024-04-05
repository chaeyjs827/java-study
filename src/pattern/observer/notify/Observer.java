package pattern.observer.notify;

public interface Observer {

    // 각 구현체에서 실행될 메소드.
    void update(int userId);

}
