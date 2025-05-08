package practisequestions.streams.should.look.once;

import java.util.Arrays;
import java.util.Comparator;

//Question  4
public class SecondHighestWordLength {
    public static void main(String[] args) {
        String string = "I am learning Streams api in java";
        Integer wordLength = Arrays.stream(string.split(" "))
                .sorted(Comparator.comparing(String::length).reversed())
                .map(String::length)
                .skip(1)
                .findFirst()
                .get();
        System.out.println(wordLength);
    }
}
