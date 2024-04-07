package fundamental.thread.basic;

public class SharedVariableStartExample {

    // 공유 변수
    private static int sharedVariable = 0;

    public static void main(String[] args) {
        // Runnable 구현
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    // 공유 변수를 1씩 증가
                    synchronized (SharedVariableStartExample.class) {
                        sharedVariable++;
                        System.out.println("Task 1 : " + sharedVariable);
                    }

                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    // 공유 변수를 1씩 증가
                    synchronized (SharedVariableStartExample.class) {
                        sharedVariable++;
                        System.out.println("Task 2 : " + sharedVariable);
                    }
                }
            }
        };

        // 두 개의 스레드 생성 및 실행
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        // 공유 변수의 최종 값 출력
        System.out.println("Final value of sharedVariable: " + sharedVariable);
    }

}
