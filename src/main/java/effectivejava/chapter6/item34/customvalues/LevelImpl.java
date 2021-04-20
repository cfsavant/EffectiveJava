package effectivejava.chapter6.item34.customvalues;

import java.util.Arrays;

public class LevelImpl {

    public static void main(String[] args) {
        Arrays.stream(Level.values()).forEach(System.out::println);
    }
}
