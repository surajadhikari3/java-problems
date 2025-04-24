package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
/*
Remove duplicates from the string and return in the same order....
input --> String s = "dabcadefg";
output --> dabcefg
*
* */
public class RemoveDuplicatesFomString {
    public static void main(String[] args) {
        String s = "dabcadefg";
        //1st approach
//        String collect = Arrays.stream(s.split("")).distinct().collect(Collectors.joining());
//        System.out.println(collect);
        //2nd approach
//        s.chars().distinct().mapToObj(x-> (char) x).forEach(System.out::println);
        //3rd approach --> Recommended
        Arrays.stream(s.split("")).distinct().forEach(System.out::println);
    }
}
