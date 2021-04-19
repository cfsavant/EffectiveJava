package effectivejava.chapter7.item48;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;



/* ----------------------------------------------------------------------------------------
                                EFFECTIVE JAVA:  Item 48
   ---------------------------------------------------------------------------------------- */
/* ----------------------------------------------------------------------------------------

** WARNING: PARALLELIZING CAN
    lead to incorrect results and unpredictable behavior (safety failures) or worsen your performance.
    be sure to test/test/test

** Even assuming that you’re using an efficiently splittable source stream,
    with a  cheap terminal operation and non-interfering function objects (don't modify the underlying stream),
    you won’t get a good perf boost from parallelization unless the pipeline is doing enough
    real work to offset the costs associated with parallelism.

** As is the case for any optimization, you must test the performance
    before and after the change to ensure that it is worth doing (Item 67).

GUIDLINE FOR PARALLELIZING:  http://gee.cs.oswego.edu/dl/html/StreamParallelGuidance.html

CASES WHERE Parallelizing a pipeline is UNLIKELY to increase its performance *****
1. if the source of the stream is from Stream.iterate, or the limit() operation is used

2. If a significant amount of work is done in the terminal operation compared
    to the overall work of the pipeline and that operation is inherently sequential,
    then parallelizing the pipeline will have limited effectiveness.

3. Stream’s collect method uses operations, which are known as mutable reductions,
     are NOT good candidates for parallelism because the overhead of combining collections is costly

4. If you write your own Stream, Iterable, or Collection implementation
     and you want decent parallel performance:
     * you must override the spliterator method and
     * test the parallel performance and safety

5. Safety failures may result from parallelizing a pipeline that uses
    mappers, filters, and other programmer - supplied function objects
    that fail to adhere to their specifications.
    The Stream specification places stringent requirements on these function objects.
    For example:
     the accumulator and combiner functions passed to
     Stream’s reduce operation must be associative, non-interfering, and stateless.
     If you violate these requirements (some of which are discussed in Item 46)
     but run your pipeline sequentially, it will likely yield correct results;
     if you parallelize it, it will likely fail, perhaps catastrophically.

7.  Writing high-quality spliterators is difficult and beyond the scope of this book.

WHEN IT'S USEFUL:
     Under the right circumstances, it is possible to achieve near-linear speedup
     in the number of processor cores simply by adding a parallel call to a stream pipeline.
     Certain domains, such as machine learning and data processing,
     are particularly amenable to these speedups.


 BEST TERMINAL OPERATIONS
     The best terminal operations for parallelism are reductions,
     where all of the elements emerging from the pipeline are combined using one of Stream’s
     reduce methods, or prepackaged reductions such as min, max, count, and sum.
     *
     * short-circuiting operations are also amenable to good performance gains:
     *    anyMatch, allMatch, and noneMatch
     *

****** As a rule, performance gains from parallelism are best on streams over these collections:
* ArrayList,
* HashMap,
* HashSet,
* and ConcurrentHashMap instances;
* native: arrays; int ranges; and long ranges. as in Arrays.stream({3,2,5,4,1});
*
* WHY:::
* What these data structures have in common is that they can all be
*  accurately and cheaply split into subranges of any desired sizes,
*  which makes it easy to divide work among parallel threads.
*
* The abstraction used by the streams library to perform this task is the spliterator,
*  which is returned by the spliterator method on Stream and Iterable.
---------------------------------------------------------------------------------------- */


/*

 This example hangs because of the use of the limit operatiion  and Stream.iterate()
 even if this didn't hang, according to Josh Bloch,
    it would not reliably print in correct order when parallelized.

 you’d have to replace the forEach terminal operation with forEachOrdered,
 which is guaranteed to traverse parallel streams in encounter order.

 */

//
/*
 Parallel stream-based program to generate the first 20 Mersenne primes - HANGS!!! (Page 222) - Effective Java
 */
public class HangingParallelMersennePrimes {
    public static void main(String[] args) {
        primes().map(p -> BigInteger.valueOf(2).pow(p.intValueExact()).subtract(ONE))
                .parallel()
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.valueOf(2), BigInteger::nextProbablePrime);
    }

}

/*
