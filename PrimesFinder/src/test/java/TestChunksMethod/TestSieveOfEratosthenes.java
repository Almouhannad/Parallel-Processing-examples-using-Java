package TestChunksMethod;

import PrimesFinder.Abstractions.IPrimesFinder;
import PrimesFinder.SieveOfEratosthenes.SieveOfEratosthenes;
import junit.framework.TestCase;

public class TestSieveOfEratosthenes extends TestCase {

    public void testSieveOfEratosthenesOutput() {
        int[] expectedPrimeCounts = {
                25, // n = 100
                168, // n = 1000
                1229, // n = 10000
                9592, // n = 100000
                78498, // n = 1000000
                664579 // n = 10000000
        };

        int[] nValues = {100, 1000, 10000, 100000, 1000000, 10000000};

        for (int i = 0; i < nValues.length; i++) {
            IPrimesFinder finder = new SieveOfEratosthenes(nValues[i], 1);
            int primeCount = finder.getPrimesCount();
            assertEquals(expectedPrimeCounts[i], primeCount);
//            System.out.println("N= " + nValues[i]);
//            System.out.println("p= " + primeCount);
        }
    }
}
