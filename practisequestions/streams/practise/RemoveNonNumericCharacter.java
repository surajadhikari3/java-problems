package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class RemoveNonNumericCharacter {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a1b2c3", "1a2b3c", "123abc");
        List<String> list1 = list.stream().map(e -> e.replaceAll("[^0-9]", "")).toList();
        System.out.println(list1);
    }
}
