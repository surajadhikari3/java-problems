package practisequestions.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//Find the occurence of each word in the string..
public class FindOccurenceOfEachCharacterInString {

    public static void main(String[] args) {
        String input = "Toronto";
        Map<String, Long> collect = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(collect);
    }
}
