package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupStringBasedOnMiddleCharacter {
    public static void main(String[] args) {
        String[] str = {"ewe", "jji", "jhj", "kwk", "aha"};

        Map<String, List<String>> collect = Stream.of(str).collect(Collectors.groupingBy(x -> x.substring(1, 2)));
        System.out.println(collect);
    }
}
