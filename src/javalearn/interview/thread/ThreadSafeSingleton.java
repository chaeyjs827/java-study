package javalearn.interview.thread;

public class ThreadSafeSingleton {

    /**
     * volatile 키워드로 선언된 변수는 모든 스레드에 대해 항상 최신 상태를 보장합니다.
     * 따라서, 한 스레드에서 instance 변수에 변경이 일어나면 다른 모든 스레드는 즉시 그 변경 사항을 볼 수 있습니다.
     *
     * volatile 을 사용하지 않으면, 다른 스레드가 초기화 중인 불완전한 객체를 참조할 가능성이 있습니다.
     * 이는 Double-checked Locking 패턴에서 특히 중요합니다.
     */
    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}

    // Double-checked Locking 패턴
    public static ThreadSafeSingleton getInstance() {
        // 첫 번째 체크(성능 최적화를 위한 것. 대부분의 인스턴스가 이미 초기화 되어있기 때문에, 불필요한 동기화 오버헤드를 피할 수 있음
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                // 두 번째 체크(동기화 블록 안에서 이루어지며, 실제 인스턴스가 null 인지를 다시 확인합니다.
                // 첫 번째 체크 이후 다른 스레드가 이미 인스턴스를 초기화했을 가능성이 있기 때문에, 두 번째 체크를 통해 인스턴스가 두 번 초기화 되는 것을 방지합니다.
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("싱글턴 인스턴스가 뭔가를 실행했다!");
    }

    public static void main(String[] args) {
        Runnable task = () -> {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
            singleton.doSomething();
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

    }

}
