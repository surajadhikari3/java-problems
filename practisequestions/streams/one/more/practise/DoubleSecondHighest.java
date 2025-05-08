package practisequestions.streams.one.more.practise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DoubleSecondHighest {
    public static void main(String[] args) {
        String s ="I am learning streams streams nioupwe api";
        List<String> strings = Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(String::length))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing((Map.Entry<Integer, List<String>> x) -> x.getKey()).reversed()) // this is bit tricky while chaining the comaparator we have to explicilty  map to the value  or else  it will return the object
//              .sorted(Map.Entry.<Integer, List<String>>comparingByKey().reversed()) // even we are using  the Map.Entry.comparingByKey() for chaining we have to provide the mep key and value type...
                .skip(1)
                .findFirst()
                .map(Map.Entry::getValue)
                .get();
        System.out.println(strings);
    }
}
