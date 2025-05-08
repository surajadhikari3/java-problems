package practisequestions.streams.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByFirstCharacter {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apricot", "chery", "blueberry", "avocado");
        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(x -> x.substring(0,1), Collectors.counting()));
        System.out.println(collect);

    }
}
