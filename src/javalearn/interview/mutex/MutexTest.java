package javalearn.interview.mutex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MutexTest {

    public static void main(String[] args) throws InterruptedException {

        Mutex mutex = new Mutex();
        // ExecutorService는 비동기 작업을 관리하는 프레임워크 입니다.
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            final int threadId = i;
            executorService.submit(() -> mutex.accessResource(threadId));
        }

        executorService.shutdown();
        boolean finished = executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(finished);
    }

}
