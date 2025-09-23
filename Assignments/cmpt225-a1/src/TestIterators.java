import integeriterators.*;

import java.util.FormatterClosedException;


public class TestIterators {

    public static void testArrayIterator1() {
        int ans[] = {0, 0, 0, 2, 5, 8, 11, 14};
        ArrayIterator iter = new ArrayIterator(ans);
        for (int i = 0; i < ans.length; i++)
            if (!iter.hasNext() || iter.next() != ans[i]) {
                System.out.println("testArrayIterator1 ERROR in iteration " + i);
                return;
            }


        if (iter.hasNext()) {
            System.out.println("testArrayIterator1 ERROR in hasNext()");
            return;
        }

        iter.reverse();
        if (!iter.hasNext() || iter.next() != 11) {
            System.out.println("testArrayIterator1 ERROR after reverse");
            return;
        }
        if (!iter.hasNext() || iter.next() != 8) {
            System.out.println("testArrayIterator1 ERROR after reverse");
            return;
        }

        System.out.println("testArrayIterator1 OK");
    }

    public static void testArrayIterator2() {
        int ans[] = {0, 0, 0, 2, 5, 8, 11, 14};
        ArrayIterator iter = new ArrayIterator(ans);


        for (int i = 0; i < 10; i++) {
            iter.reverse();
            if (!iter.hasNext()) {
                System.out.println("testArrayIterator2 ERROR in reverse in the beginning " + i);
                return;
            }
        }

        for (int i = 0; i < 5; i++)
            if (!iter.hasNext() || iter.next() != ans[i]) {
                System.out.println("testArrayIterator2 ERROR in iteration " + i);
                return;
            }


        if (!iter.hasNext()) {
            System.out.println("testArrayIterator2 ERROR in hasNext()");
            return;
        }

        iter.reverse();
        if (!iter.hasNext() || iter.next() != 2) {
            System.out.println("testArrayIterator2 ERROR after reverse1");
            return;
        }

        iter.reverse();
        if (!iter.hasNext() || iter.next() != 5) {
            System.out.println("testArrayIterator2 ERROR after reverse2");
            return;
        }

        System.out.println("testArrayIterator2 OK");
    }


    public static void testRangeIterator1() {

        RangeIterator iter = new RangeIterator(5);
        for (int i = 0; i < 5; i++)
            if (!iter.hasNext() || iter.next() != i) {
                System.out.println("testRangeIterator1 ERROR in iteration " + i);
                return;
            }

        if (iter.hasNext()) {
            System.out.println("testRangeIterator1 ERROR in hasNext()");
            return;
        }

        iter.reverse();

        for (int i = 0; i < 4; i++)
            if (!iter.hasNext() || iter.next() != 3 - i) {
                System.out.println("testRangeIterator1 ERROR after reverse in iteration i =" + i);
                return;
            }

        if (iter.hasNext()) {
            System.out.println("testRangeIterator1 ERROR in hasNext() after reverse");
            return;
        }

        iter.reverse();

        if (!iter.hasNext()) {
            System.out.println("testRangeIterator1 ERROR in hasNext() after second reverse");
            return;
        }

        System.out.println("testRangeIterator1 OK");
    }

    public static void testRangeIterator2() {

        RangeIterator iter = new RangeIterator(10,10);
        for (int i = 0; i < 10; i++)
            if (!iter.hasNext() || iter.next() != 10+i) {
                System.out.println("testRangeIterator2 ERROR in iteration " + i);
                return;
            }

        if (iter.hasNext()) {
            System.out.println("testRangeIterator2 ERROR in hasNext()");
            return;
        }

        iter.reverse();

        for (int i = 0; i < 9; i++)
            if (!iter.hasNext() || iter.next() != 18 - i) {
                System.out.println("testRangeIterator2 ERROR after reverse in iteration i =" + i);
                return;
            }

        if (iter.hasNext()) {
            System.out.println("testRangeIterator2 ERROR in hasNext() after reverse");
            return;
        }

        iter.reverse();

        if (!iter.hasNext() || iter.next() != 11) {
            System.out.println("testRangeIterator2 ERROR in hasNext() after second reverse");
            return;
        }

        System.out.println("testRangeIterator2 OK");
    }


    public static void testPrimes1() {
        int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};

        PrimeNumbersIterator iter = new PrimeNumbersIterator();
        for (int i = 0; i < primes.length; i++)
            if (!iter.hasNext() || iter.next() != primes[i]) {
                System.out.println("testPrimes1 ERROR in iteration " + i);
                return;
            }

        System.out.println("testPrimes1 OK");
    }

    public static void testPrimes2() {
        int primes4[] = {7, 11, 13, 17, 19, 23, 29};
        int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23};

        PrimeNumbersIterator iter = new PrimeNumbersIterator(4);
        for (int i = 0; i < primes4.length-1; i++) // go up to 23
            if (!iter.hasNext() || iter.next() != primes4[i]) {
                System.out.println("testPrimes2 ERROR in iteration " + i);
                return;
            }

        iter.reverse();

        for (int i = 0; i < primes.length-1; i++)
            if (!iter.hasNext() || iter.next() != primes[primes.length-i-2]) {
                System.out.println("testPrimes2 ERROR after reverse, i= " + i);
                return;
            }

        if (iter.hasNext()) {
            System.out.println("testPrimes2 ERROR after second loop");
            return;
        }

        iter.reverse();

        if (!iter.hasNext() || iter.next() != 3) {
            System.out.println("testPrimes2 ERROR after second reverse");
            return;
        }

        System.out.println("testPrimes2 OK");
    }


    public static void main(String[] args) {
        testArrayIterator1();
        testArrayIterator2();
        System.out.println("");
        testRangeIterator1();
        testRangeIterator2();
        System.out.println("");
        testPrimes1();
        testPrimes2();
    }
}