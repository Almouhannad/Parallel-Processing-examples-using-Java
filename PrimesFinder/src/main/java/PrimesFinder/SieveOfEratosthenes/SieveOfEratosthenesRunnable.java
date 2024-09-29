package PrimesFinder.SieveOfEratosthenes;

public class SieveOfEratosthenesRunnable implements Runnable {
    private int start;
    private int end;
    private boolean[] isPrime;

    /**
     * @param start   left side of range
     * @param end     right side of range
     * @param isPrime isPrime array in main task
     */
    public SieveOfEratosthenesRunnable(int start, int end, boolean[] isPrime) {
        this.start = start;
        this.end = end;
        this.isPrime = isPrime;
    }

    @Override
    public void run() {
        for (int i = start; i * i <= end; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= end; j += i) {
                    synchronized (isPrime) {
                        isPrime[j] = false;
                    }
                }
            }
        }
    }
}