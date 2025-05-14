package practisequestions.streams.should.look.once;

import java.util.Arrays;
import java.util.Comparator;

//Question  4
public class SecondHighestWordLength {
    public static void main(String[] args) {
        String string = "I am learning Streams api in java";

        Integer s = Arrays.stream(string.split(" "))
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1)
                .map(String::length)
                .findFirst()
                .get();
        System.out.println(s);

    }
}
