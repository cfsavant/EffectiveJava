package effectivejava.chapter7.item48;

import java.util.stream.IntStream;

public class StatefulFixExample {

    public static void main (String[] args) {
        for (int i = 0; i < 5; i++) {
            IntStream stream = IntStream.of(1, 2, 1, 2, 3, 4, 4, 5);
            int sum = stream.parallel().distinct().sum();
            System.out.println(sum);
        }
    }
}