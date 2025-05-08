package practisequestions.streams.one.more.practise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueElements {
    public static void main(String[] args) {
//        String input = "i am am Learning learNing, Java . java Java.";
        String input = "i am am Learning learNing,   Java . java Java";
        //output: i am Learning, Java.

        String collect = Arrays.stream(input.split("[\\s\\p{Punct}]+"))
                .distinct()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.toList()))
                .keySet()
                .stream()
                .collect(Collectors.joining(" "));

        System.out.println(collect);
    }
}
