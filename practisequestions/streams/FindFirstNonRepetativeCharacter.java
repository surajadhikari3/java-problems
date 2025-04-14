package practisequestions.streams;

import java.util.*;
import java.util.stream.Collectors;

public class FindFirstNonRepetativeCharacter {

    public static void main(String[] args) {
        String input = "Hello World";

//        String s = Arrays.stream(input.split("")).filter(c -> c.indexOf(c) == c.lastIndexOf(c))
//                .findFirst().get();
//        System.out.println(s);


        //Second way of doing it

        Map<String, Long> collect = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new,  Collectors.counting()));


        String s = collect.entrySet().stream().filter(m -> m.getValue() == 1).
                map(Map.Entry::getKey).findFirst().get();
        System.out.println(s);

    }
}