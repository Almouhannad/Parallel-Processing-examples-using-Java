package SieveOfEratosthenes;

import Abstractions.IPrimesFinder;

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes implements IPrimesFinder {

    private final int n;
    private final int threadsCount;
    private final List<Integer> primes;

    /**
     * @param n            find primes in [2,n]
     * @param threadsCount threads to use
     */
    public SieveOfEratosthenes(int n, int threadsCount) {
        this.n = n;
        this.threadsCount = threadsCount;
        primes = new ArrayList<>();
    }

    @Override
    public int getPrimesCount() {
        boolean[] isPrime = new boolean[n + 10];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        Thread[] threads = new Thread[threadsCount];
        // Range for each thread
        int range = (n - 1) / threadsCount;
        for (int i = 0; i < threadsCount; i++) {
            // start and end for each thread
            int start = i * range + 2;
            int end = (i == threadsCount - 1) ? n : (start + range - 1);
            // Create a new thread
            threads[i] = new Thread(new SieveOfEratosthenesRunnable(isPrime, start, end));
            // Start the thread
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < threadsCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Store primes
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes.size();
    }
}