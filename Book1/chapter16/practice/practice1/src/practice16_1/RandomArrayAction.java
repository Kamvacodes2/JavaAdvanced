package practice16_1;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayAction extends RecursiveAction {
    private final int threshold;
    private final int[] myArray;
    private int start;
    private int end;

    public RandomArrayAction(int[] myArray, int start, int end, int threshold) {
        this.myArray = myArray;
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    protected void compute() {
        if (end - start < threshold) {
            for (int i = start; i <= end; i++) {
                myArray[i] = ThreadLocalRandom.current().nextInt();
            }
        }else{
            int mid = (end - start) / 2+start;
            RandomArrayAction r1 = new RandomArrayAction(myArray, start, mid, threshold);
            RandomArrayAction r2 = new RandomArrayAction(myArray, mid + 1, end, threshold);
            invokeAll(r1, r2);
        }
    }
}
