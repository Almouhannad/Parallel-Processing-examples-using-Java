package PrimesFinder.ChunksMethod;

import java.util.List;

public class ChunksMethodRunnable implements Runnable {

    private final List<Integer> primes;

    // thread is finding primes in [left, right]
    private final int start;
    private final int end;

    /**
     * @param primes isPrime in parent process
     * @param left   start index
     * @param right  end index
     */
    public ChunksMethodRunnable(int left, int right, List<Integer> primes) {
        this.start = left;
        this.end = right;
        this.primes = primes;
    }

    @Override
    public void run() {
        for (int number = start; number <= end; number++) {
            if (ChunksMethod.isPrime(number)) {
                // To ensure no conflicts in editing
                synchronized (primes) {
                    primes.add(number);
                }
            }
        }
    }

}
