package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.Comparator;

//Find the word that has the highest length in the sentence
public class HighestLengthInWord1 {
    public static void main(String[] args) {
        String sentence = "I am learning java stream";
        String stringWithMaxLength = Arrays.stream(sentence.split(" ")).max(Comparator.comparing(String::length)).get();
        System.out.println(stringWithMaxLength);
    }
}
