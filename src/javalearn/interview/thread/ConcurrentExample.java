package javalearn.interview.thread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * thread-safe 하다는 것은 두 개 이상의 스레드가 동시에 객체나 자원에 접근하더라도, 각 스레드가 의도한 대로 동작하며, 연산 결과가 올바르게 유지되는 것을 의미합니다.
 * 주로 동기화(syncrhonized)를 통해 이루어집니다.
 *
 * 1. java.util.concurrent 패키지 사용하기
 * 이 패키지에는 동시성 문제를 해결할 수 있는 다양한 클래스가 포함되어 있습니다.
 *
 */

public class ConcurrentExample {

    private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public void add(String key, int value) {
        //  원자성을 보장하는 compute 메소드를 사용하자
        map.compute(key, (k, v) -> (v == null) ? value : v + value);
    }

    public int get(String key) {
        return map.getOrDefault(key, 0);
    }

    public static void main(String[] args) {
        ConcurrentExample example = new ConcurrentExample();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                example.add("key", 1);
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(example.get("key"));
    }

}
