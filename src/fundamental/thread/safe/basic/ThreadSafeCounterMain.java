package fundamental.thread.safe.basic;

public class ThreadSafeCounterMain {

    public static void main(String[] args) {
        ThreadSafeCounter threadSafeCounter = new ThreadSafeCounter();

        // increment() 메서드 테스트
        threadSafeCounter.increment(); // count: 1
        System.out.println("After increment, count: " + threadSafeCounter.getCount());

        // decrement() 메서드 테스트
        threadSafeCounter.decrement(); // count: 0
        System.out.println("After decrement, count: " + threadSafeCounter.getCount());


        // 스레드 안전성 테스트
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                threadSafeCounter.increment();
            }
        };

        // 두 개의 스레드를 사용하여 동시에 increment() 메서드 호출
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        // 두 스레드가 작업을 완료할 때까지 대기
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 모든 작업이 완료된 후 카운터 값 확인
        System.out.println("After concurrent increment, count: " + threadSafeCounter.getCount());

    }

}
