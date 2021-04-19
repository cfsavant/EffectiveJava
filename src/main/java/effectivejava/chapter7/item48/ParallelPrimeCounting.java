package effectivejava.chapter7.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class ParallelPrimeCounting {

    static long noStreamPi(long n) {
        return LongStream.rangeClosed(2, n) .mapToObj(BigInteger::valueOf) .filter(i -> i.isProbablePrime(50)) .count();
    }

    // Prime-counting stream pipeline - parallel version (Page 225)
    static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    public static void main(String[] args) { System.out.println(noStreamPi(10_000_000)); }
/*    public static void main(String[] args) { System.out.println(nonStreamPi(10_000_000));} */
}