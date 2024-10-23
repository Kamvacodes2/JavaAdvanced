package example;

import java.util.concurrent.ThreadLocalRandom;

public class SingleThreadExanple {
    public static void main(String[] args) {
//        Large dataset
        int[] data = new int[1024 * 1024 * 256]; // 1GB
        for (int i = 0; i < data.length; i++) {
//            Fill the array with values
            data[i] = ThreadLocalRandom.current().nextInt();
        }

        int max = Integer.MIN_VALUE;
        for(int value : data) {
//            Sequentially search the array for the largest value
            if(value > max) {
                max = value;
            }
        }
        System.out.println("Max value is: " + max);
    }
}
