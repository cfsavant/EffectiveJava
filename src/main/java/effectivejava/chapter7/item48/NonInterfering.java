package effectivejava.chapter7.item48;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
Non-Interfering: doesn't modify the base stream.

 */
public class NonInterfering {



    public static void main(String[] args) {


//        List<String> alphabets = new ArrayList<>(Arrays.asList("aa", "bbb", "cat", "dog")); alphabets.forEach(s -> System.out.println(s));
//        alphabets.stream().forEach(System.out::println);


        List<String> l = new ArrayList(Arrays.asList("one", "two"));
        Stream<String> sl = l.stream();
        l.add("three");
        String s = sl.collect(joining(" "));


        Set<Integer> seen = new HashSet<Integer>(){{ add(1);add(2);add(3); }};

        Set<Integer> syncSeen = Collections.synchronizedSet(new HashSet<Integer>(){{
                                                            add(1);
                                                            add(2);
                                                            add(3);
                                                        }}
        );

        List<Integer> lt =
                syncSeen.parallelStream().map(e -> { if (seen.add(5)) return 0; else return e; })
                .collect(toList());
        lt.forEach(System.out::println);
//        seen.stream()
//                .map(e -> { if (seen.add(e)) return e; else return e; })
//                .collect(toList());
        //st.forEach(System.out::println);

//                .collect(toList());
//        result.forEach(p -> System.out.println(p));

    }


}
