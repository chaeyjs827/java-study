package javalearn.interview.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreService {

    private final Semaphore semaphore = new Semaphore(3);

    public void accessResource(int threadId) {
        try {
            System.out.println("Thread " + threadId + " 자원 접근을 시도합니다.");
            semaphore.acquire();

            try {
                System.out.println("Thread " + threadId + " 자원에 접근했습니다. 로직을 수행합니다.");
                Thread.sleep(1000);
            } finally {
                System.out.println("Thread " + threadId + " 자원 사용 완료 후 release 합니다.");
                semaphore.release();
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
