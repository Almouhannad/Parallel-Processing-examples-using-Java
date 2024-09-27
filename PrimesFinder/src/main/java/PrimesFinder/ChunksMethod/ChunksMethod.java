package PrimesFinder.ChunksMethod;

import PrimesFinder.Abstractions.IPrimesFinder;

import java.util.ArrayList;
import java.util.List;

/**
 * This class uses chunks method to find primes in [2,n]
 */
public class ChunksMethod implements IPrimesFinder {
    private int n;
    private int threadsCount;
    public List<Integer> primes;

    /**
     * @param n            to find primes in [2,n]
     * @param threadsCount number of threads to use
     */
    public ChunksMethod(int n, int threadsCount) {
        this.n = n;
        this.threadsCount = threadsCount;
        this.primes = new ArrayList<>();
    }

    /**
     * @return the count of prime numbers found
     */
    @Override
    public int getPrimesCount() {
        findPrimes();
        return primes.size();
    }

    /**
     * Fill "Primes" list with primes in [2,n]
     */
    private void findPrimes() {
        Thread[] threads = new Thread[threadsCount];
        int chunkSize = n / threadsCount;
        // Same chunk size for each thread

        // create and start each thread
        for (int i = 0; i < threadsCount; i++) {
            int start = i * chunkSize + 2;
            int end = (i == threadsCount - 1) ? n : start + chunkSize - 1;
            ChunksMethodRunnable task = new ChunksMethodRunnable(this, start, end);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        // wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}