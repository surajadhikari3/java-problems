package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class FindTheOccurenceOfWordInSentence {
    public static void main(String[] args) {
        String sentence = "I am learning streams in java java";
        Collectors.groupingBy(x-> x);
        Map<String, Long> collect = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x,LinkedHashMap::new,  Collectors.counting()));
        System.out.println(collect);
    }
}
