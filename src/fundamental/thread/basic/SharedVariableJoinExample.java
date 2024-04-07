package fundamental.thread.basic;

public class SharedVariableJoinExample {

    // 공유 변수
    private static int sharedVariable = 0;

    public static void main(String[] args) {
        // Runnable 구현
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    // 공유 변수를 1씩 증가
                    synchronized (SharedVariableJoinExample.class) {
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
                    synchronized (SharedVariableJoinExample.class) {
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

        // 두 스레드가 작업을 완료할 때까지 대기
        // join 메소드를 사용하면 이전 스레드가 종료될 때까지 기다림
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 공유 변수의 최종 값 출력
        System.out.println("Final value of sharedVariable: " + sharedVariable);
    }

}
