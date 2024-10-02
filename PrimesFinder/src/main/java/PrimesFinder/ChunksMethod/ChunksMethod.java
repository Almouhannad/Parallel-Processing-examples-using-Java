package PrimesFinder.ChunksMethod;

import PrimesFinder.Abstractions.IPrimesFinder;

import java.util.ArrayList;
import java.util.List;

public class ChunksMethod implements IPrimesFinder {

    private final int n;
    private final int threadsCount;
    private final List<Integer> primes;

    /**
     * @param n            find primes in [2,n]
     * @param threadsCount threads to use
     */
    public ChunksMethod(int n, int threadsCount) {
        this.n = n;
        this.threadsCount = threadsCount;
        this.primes = new ArrayList<>();
    }

    @Override
    public int getPrimesCount() {

        Thread[] threads = new Thread[threadsCount];
        // Range for each thread
        int chunkSize = (n - 1) / threadsCount + 1;
        for (int i = 0; i < threadsCount; i++) {
            // start and end for each thread
            int start = 2 + i * chunkSize;
            int end = chunkSize * (i + 1) + 1;
            end = Math.min(end, n);
            // Create a new thread
            threads[i] = new Thread(new ChunksMethodRunnable(start, end, primes));
            // Start the thread
            threads[i].start();
        }

        for (int i = 0; i < threadsCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return primes.size();
    }

    /**
     * Check if number is prime (Enhanced method with low constant)
     * in O(sqrt(number) / 6)
     */
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        int sqrtN = (int) Math.sqrt(number);
        for (int i = 5; i <= sqrtN; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

}
