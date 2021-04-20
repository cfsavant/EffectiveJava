package effectivejava.chapter7.item34.customvalues;

import effectivejava.chapter7.item34.constants.Orange;

import java.util.Arrays;

public class LevelImpl {

    public static void main(String[] args) {
        Arrays.stream(Level.values()).forEach(System.out::println);
    }
}
