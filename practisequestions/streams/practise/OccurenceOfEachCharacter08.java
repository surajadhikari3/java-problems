package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class OccurenceOfEachCharacter08 {
    public static void main(String[] args) {
        String s = "Mississippi";
      Map<String, Long> printOccurence =  Arrays.stream(s.split("")).collect(Collectors.groupingBy(x-> x , Collectors.counting()));
        System.out.println(printOccurence);
    }
}
