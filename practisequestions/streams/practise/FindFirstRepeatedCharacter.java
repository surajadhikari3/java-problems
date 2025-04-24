package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

//Given a string find the first repeated character
public class FindFirstRepeatedCharacter {
    public static void main(String[] args) {
        String s = "Hello World";
        //first method
        String s1 = Arrays.stream(s.split("")).filter(c -> s.indexOf(c) != s.lastIndexOf(c)).findFirst().get();
        System.out.println(s1);
        //Second method
        String cd = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(m -> m.getValue() > 1).map(Map.Entry::getKey).findFirst().get();

        System.out.println(cd);
    }


}
