package PrimesFinder.SieveOfEratosthenes;

import java.util.BitSet;

public class SieveOfEratosthenesRunnable implements Runnable {
    private int start;
    private int end;
    private BitSet isPrime;

    /**
     * @param start   left side of range
     * @param end     right side of range
     * @param isPrime isPrime array in main task
     */
    public SieveOfEratosthenesRunnable(int start, int end, BitSet isPrime) {
        this.start = start;
        this.end = end;
        this.isPrime = isPrime;
    }

    @Override
    public void run() {
//        System.out.println("St: " + start);
//        System.out.println("En: " + end);
//        System.out.println("Thread start");
        for (int i = start; i * i <= end; i++) {
            if (isPrime.get(i)) {
                for (int j = i * i; j <= end; j += i) {
                    if (j < 0)
                        continue;
                    synchronized (isPrime) {
                        isPrime.clear(j);
                    }
                }
            }
        }
//        System.out.println("Thread end");
    }
}