package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


//Occuring exactly once means its index is equal to the last Index
public class FirstNonRepeatedChararcter11 {
    public static void main(String[] args) {
        String s = "Hello World";

        //1st approach.........
        String s1 = Arrays.stream(s.split("")).filter(c -> s.indexOf(c) == s.lastIndexOf(c)).findFirst().get();
        System.out.println(s1);

        //2nd  approach
        String s2 = Arrays.stream(s.split("")).collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println(s2);
    }
}
