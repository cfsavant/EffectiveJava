package effectivejava.chapter6.item34.streams;

import effectivejava.chapter6.item34.constants.Orange;

import java.util.Arrays;
/*
    default value is the same as the string.
    By default, enums don’t require constructor definitions
     and their default values are always the string used in the declaration
 */
public class OrangeStreamImpl {
    public static void main(String[] args) {
        Arrays.stream(Orange.values()).forEach(System.out::println);
    }
}
