package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapOfStringWithLength {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("orange", "banana", "kiwi");
        Map<String, Integer> collect =
                fruits.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(collect);
    }
}
