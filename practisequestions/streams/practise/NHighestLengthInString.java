package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.Comparator;

public class NHighestLengthInString {
    public static void main(String[] args) {
        String s = " I am learning Streams API in Java";
        String highestNLength = Arrays.stream(s.split(" "))
                .sorted(Comparator.comparing(String::length).reversed()).skip(2)
                .findFirst().get();
        System.out.println(highestNLength);
    }
}
