package SieveOfEratosthenes;

import Abstractions.PrimesFinder;

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes extends PrimesFinder {


    /**
     * @param n            find primes in [2,n]
     * @param threadsCount threads to use
     */
    public SieveOfEratosthenes(int n, int threadsCount) {
        super(n, threadsCount);
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