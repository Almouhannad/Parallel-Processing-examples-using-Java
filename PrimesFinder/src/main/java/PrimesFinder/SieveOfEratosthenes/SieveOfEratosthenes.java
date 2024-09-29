package PrimesFinder.SieveOfEratosthenes;

import PrimesFinder.Abstractions.IPrimesFinder;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class SieveOfEratosthenes implements IPrimesFinder {
    private int n;
    private int threadsCount;
    public List<Integer> primes;

    /**
     * @param n            to find primes in [2,n]
     * @param threadsCount number of threads to use
     */
    public SieveOfEratosthenes(int n, int threadsCount) {
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
        BitSet isPrime = new BitSet(n + 10);
        for (int i = 2; i <= n; i++) {
            isPrime.set(i);
        }

        Thread[] threads = new Thread[threadsCount];
        int chunkSize = (n - 1) / threadsCount;

        // create and start each thread
        for (int i = 0; i < threadsCount; i++) {
            int start = i * chunkSize + 2;
            int end = (i == threadsCount - 1) ? n : start + chunkSize + 1;
            SieveOfEratosthenesRunnable task = new SieveOfEratosthenesRunnable(start, end, isPrime);
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

        // add primes to the list
        for (int i = 2; i <= n; i++) {
            if (isPrime.get(i)) {
                primes.add(i);
            }
        }
    }
}