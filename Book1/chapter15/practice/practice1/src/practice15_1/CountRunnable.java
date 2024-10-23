package practice15_1;

public class CountRunnable implements Runnable {

    final int count;
    final String threadName;

    // Setup Constructor to initialize variables
    public CountRunnable(int count, String name) {
        this.count = count;
        threadName = name;
    }

    public void run() {
        // Count with for loop
        for (int i = 0; i < count; i++) {
            System.out.println("Thread " + threadName + ": " + i);
        }
    }
}

