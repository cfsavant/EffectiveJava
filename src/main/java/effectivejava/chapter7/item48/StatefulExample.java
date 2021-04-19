package effectivejava.chapter7.item48;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/* fix with Synchronized Set but that would undermine the benefit of parallelism. */
public class StatefulExample {

    public static void main (String[] args) {
        for (int i = 0; i < 5; i++) {

//            Set<Integer> seen = new HashSet<>();
            Set<Integer> seen = Collections.synchronizedSet(new HashSet<>());
            IntStream stream = IntStream.of(16, 6, 5, 7, 8, 9, 9, 17);
            int sum = stream.parallel().map(
                    //stateful behavioral parameter.
                        e -> {
                              if (seen.add(e))
                                  return e;
                              else
                                  return 0;
                            }
                    )
                    .sum();

            System.out.println(sum);

        }
    }
}