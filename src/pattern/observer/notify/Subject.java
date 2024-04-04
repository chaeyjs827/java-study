package pattern.observer.notify;

/**
 * Observer 패턴을 구현할 때 일반적으로 하나의 Subject를 만듭니다.
 * 하나의 Subject 클래스를 만들고 이를 여러 Observer 인스턴스들이 관찰하는 형태입니다.
 *
 * Subject 클래스에서 ObserverList 에 register, remove 하는 메소드와,
 * 실제 옵저버 패턴이 실행될 doObserver 메소드도 함께 선언합니다.
 */

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void doObserver(int userId);

}
