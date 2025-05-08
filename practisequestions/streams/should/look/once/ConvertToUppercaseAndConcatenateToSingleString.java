package practisequestions.streams.should.look.once;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Study collectors.joining()
public class ConvertToUppercaseAndConcatenateToSingleString {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        String collect = list.stream().map(String::toUpperCase).collect(Collectors.joining(" "));
        System.out.println(collect);
    }
}
