package fundamental.thread.basic;

public class ParallelProcessingExample {

    /**
     * 자바에서 스레드를 사용하려면 Runnable 인터페이스를 사용하면 됩니다.
     * Runnable 인터페이스를 구현하는 클래스는 스레드가 실행할 작업을 정의할 수 있습니다.
     * -> * Runnable 구현 시 run 메소드가 오버리아드 됩니다.
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Thread 1 : " + i);
                    try {
                        Thread.sleep(100);  // 0.1초 대기
                    } catch  (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Thread 2: " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

    }

}
