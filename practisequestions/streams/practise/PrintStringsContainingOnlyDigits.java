package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class PrintStringsContainingOnlyDigits {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("123", "abc", "123abc", "45");
        List<String> list1 = list.stream().filter(x -> x.matches("\\d+")).toList();
        System.out.println(list1);
    }
}
