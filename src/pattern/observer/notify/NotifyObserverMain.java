package pattern.observer.notify;

public class NotifyObserverMain {

    public static void main(String[] args) {
        Observer notifyObserver = new NotifyObserver();
        Observer adminLogObserver = new AdminLogObserver();
        Observer adminMemoObserver = new AdminMemoObserver();

        UserUpdateSubject userUpdateSubject = new UserUpdateSubject();
        userUpdateSubject.registerObserver(notifyObserver);
        userUpdateSubject.registerObserver(adminLogObserver);
        userUpdateSubject.registerObserver(adminMemoObserver);

        userUpdateSubject.doObserver(1000);
    }

}
