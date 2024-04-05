package pattern.observer.notify;

import java.util.ArrayList;
import java.util.List;

// Subject 인터페이스 구현체
public class UserUpdateSubject implements Subject {

    List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void doObserver(int userId) {
        for (Observer observer : observerList) {
            observer.update(userId);
        }
    }
}
