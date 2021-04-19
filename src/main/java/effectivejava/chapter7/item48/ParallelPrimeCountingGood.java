package effectivejava.chapter7.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class ParallelPrimeCountingGood {
    public static void main(String[] args) {

    }
    // Prime-counting stream pipeline - benefits from parallelization
    static long pi(long n) {
        return LongStream.rangeClosed(2, n) .mapToObj(BigInteger::valueOf) .filter(i -> i.isProbablePrime(50)) .count();
    }
}
