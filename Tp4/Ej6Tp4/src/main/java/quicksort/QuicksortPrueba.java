package quicksort;

import java.util.Arrays;
import java.util.Random;

public class QuicksortPrueba {

    private final static int SIZE = 7000;
    private final static int MAX = 20;

    public static void main(String[] args) {
        int[] numbers = new int[SIZE];
        int[] numbers1 = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
            numbers1[i] = numbers[i];
        }

        long startTime;
        long stopTime;
        long elapsedTime;

        startTime = System.nanoTime();
        Quicksort sorter = new Quicksort();
        sorter.sort(numbers1);
        stopTime = System.nanoTime();
        elapsedTime = stopTime - startTime;
        System.out.println("Compare Quicksort " + elapsedTime);

        startTime = System.nanoTime();
        Arrays.sort(numbers);
        stopTime = System.nanoTime();
        elapsedTime = stopTime - startTime;
        System.out.println("Compare Standard Java sort " + elapsedTime);

    }

}
