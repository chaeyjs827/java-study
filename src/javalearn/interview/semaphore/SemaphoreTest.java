package javalearn.interview.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        SemaphoreService semaphoreService = new SemaphoreService();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            final int threadId = i;
            executor.submit(() -> semaphoreService.accessResource(threadId));
        }

        executor.shutdown();
        boolean finished = executor.awaitTermination(20, TimeUnit.SECONDS);
    }

}
