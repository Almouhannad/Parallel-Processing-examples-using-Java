package PrimesFinder.SieveOfAtkin;


public class SieveOfAtkinRunnable implements Runnable {
    private int start;
    private int end;
    private boolean[] isPrime;

    /**
     * @param start   left side of range
     * @param end     right side of range
     * @param isPrime isPrime array in main task
     */
    public SieveOfAtkinRunnable(int start, int end, boolean[] isPrime) {
        this.start = start;
        this.end = end;
        this.isPrime = isPrime;
    }

    @Override
    public void run() {
        for (int x = start; x <= end; x++) {
            for (int y = start; y * y <= x; y++) {
                int n = 4 * x * x + y * y;
                if (n <= isPrime.length && (n % 12 == 1 || n % 12 == 5)) {
                    synchronized (isPrime) {
                        isPrime[n] = !isPrime[n];
                    }
                }
                n = 3 * x * x + y * y;
                if (n <= isPrime.length && n % 12 == 7) {
                    synchronized (isPrime) {
                        isPrime[n] = !isPrime[n];
                    }
                }
                n = 3 * x * x - y * y;
                if (x > y && n <= isPrime.length && n % 12 == 11) {
                    synchronized (isPrime) {
                        isPrime[n] = !isPrime[n];
                    }
                }
            }
        }
    }
}