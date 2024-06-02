package javalearn.interview.mutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mutex {

    // ReentrantLock 은 스레드 간에 상호 배제를 구현하기 위해 사용됩니다.
    // 상호 배제(Mutual Exclusive) 는 Mutex 의 full name 입니다.
    private final Lock lock = new ReentrantLock();

    public void accessResource(int threadId) {
        // 자원 진입 시도
        System.out.println("Thread : " + threadId + " 자원에 진입을 시도합니다.");
        // 자원에 접근을 할 경우 lock 을 해버림. 스레드는 lock 을 얻을 때까지 대기 합니다.(busy waiting)
        // non-busy-waiting 과는 다르게 lock 을 얻을 때까지 다른 CPU 등을 사용하지 않습니다.
        lock.lock();
        try {
            // 자원 진입!
            System.out.println("Thread " + threadId + " 자원에 진입 성공하여 로직을 수행 합니다.");
            // 자원에 대한 작업을 수행하는 동안 지연을 추가하여 로그 출력 관찰
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("Thread " + threadId + " 자원 사용이 종료되어 lock 을 반환합니다.");
            // 자원 사용 완료 시 lock 을 해제하여 다른 스레드의 접근을 허용합니다.
            lock.unlock();
        }
    }

}
