package Abstractions;

import java.util.ArrayList;
import java.util.List;

public abstract class PrimesFinder {
    protected final int n;
    protected final int threadsCount;
    protected final List<Integer> primes;

    /**
     * @param n            find primes in [2,n]
     * @param threadsCount threads to use
     */
    public PrimesFinder(int n, int threadsCount) {
        this.n = n;
        this.threadsCount = threadsCount;
        this.primes = new ArrayList<>();
    }

    public abstract int getPrimesCount();
}
