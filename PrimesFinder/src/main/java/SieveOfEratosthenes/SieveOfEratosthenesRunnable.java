package SieveOfEratosthenes;

public class SieveOfEratosthenesRunnable implements Runnable {

    private final boolean[] isPrime;

    // thread is finding primes in [left, right]
    private final int left;
    private final int right;

    /**
     * @param isPrime isPrime in parent process
     * @param left    start index
     * @param right   end index
     */
    public SieveOfEratosthenesRunnable(boolean[] isPrime, int left, int right) {
        this.isPrime = isPrime;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        for (int i = 2; i * i <= isPrime.length - 1; i++) {
            if (isPrime[i]) {
                // starting index for marking multiples of i not prime
                int j0 = Math.max(i * i, (left + i - 1) / i * i);
                for (int j = j0; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}