package fundamental.thread.safe.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * ReentrantLock 을 사용하여 스레드 안전한 카운터를 구현했습니다.
 * lock() 메서드로 락을 획득하고, 작업이 완료된 후에는 unlock()으로 락을 해제합니다.
 *
 * 단순합니다. count 라는 하나의 자원을 멀티 스레드가 사용하려고 할 때,
 * 증가, 감소, 갯수 확인을 할 때 lock 을 실행하여 변화를 차단합니다.
 */

public class ThreadSafeCounter {

    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
            System.out.println("카운트 증가 - count : " + count);
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            count--;
            System.out.println("카운트 감소 - count : " + count);
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }

}
