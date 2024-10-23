package practice15_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        // Setup Executor
        ExecutorService es = Executors.newCachedThreadPool();
        // Submit Runnable
        es.submit(new CountRunnable(30,"A"));
        es.submit(new CountRunnable(10,"B"));
        es.submit(new CountRunnable(20,"C"));
        // Showndown Executor Service
        es.shutdown();
    }
}
