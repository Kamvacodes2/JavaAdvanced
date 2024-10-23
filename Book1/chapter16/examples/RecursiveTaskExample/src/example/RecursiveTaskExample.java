package example;

import java.util.concurrent.RecursiveTask;

//Extends->Result type of the task
public class RecursiveTaskExample extends RecursiveTask<Integer> {
    private final int threshold;
//    Data to process
    private final int[] myArray;
    private int start;
    private int end;

    public RecursiveTaskExample(int[] myArray, int start, int end, int threshold){
        this.myArray = myArray;
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    protected Integer compute() {
//        Compute(Below threshold)
//        Decide the threshold
        if (end - start < threshold) {
//            Find the max
            int max = Integer.MIN_VALUE;
            for(int i =start;i<=end;i++){
                int n = myArray[i];
                if(n > max){
                    max = n;
                }
            }
            return max;
        }else {
//            Compute(Above threshold)
//            Split data and create tasks
            int midway = (end - start)/2+start;
//            Task for left half of data
            RecursiveTaskExample a1 = new RecursiveTaskExample(myArray, start, midway, threshold);
            a1.fork();
//            Task for the right half of the data
            RecursiveTaskExample a2 = new RecursiveTaskExample(myArray, midway+1, end, threshold);
            return Math.max(a2.compute(), a1.join());
        }
    }
}
