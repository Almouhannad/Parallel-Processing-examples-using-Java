package PrimesFinder.ChunksMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the part of chunks method that will be each thread
 * It find primes in [start,end]
 * and add them to "primes" list
 */
public class ChunksMethodRunnable implements Runnable {
    private ChunksMethod chunksMethod; // the ChunksMethod object that this runnable belongs to
    private int start;
    private int end;

    /**
     * @param chunksMethod the ChunksMethod object that this task belongs to
     * @param start        left side of range
     * @param end          right side of range
     */
    public ChunksMethodRunnable(ChunksMethod chunksMethod, int start, int end) {
        this.chunksMethod = chunksMethod;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        List<Integer> primes = new ArrayList<>(); // list to store primes in [start,end]
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i); // add the prime number to the list
            }
        }
        // sync. access to the ChunksMethod object to ensure adding with no conflicts
        synchronized (chunksMethod) {
            chunksMethod.primes.addAll(primes);
        }
    }

    /**
     * Checks if a number is prime.
     *
     * @param num the number to check
     * @return true if the number is prime, false otherwise
     */
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}