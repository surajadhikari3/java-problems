package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordsWithNnumberOfVowels6 {
    public static void main(String[] args) {
        String s = "I am learning streams API in java";
        //Note --> ^ inside the [] regex is the negation.....
        List<String> list = Arrays.stream(s.split(" "))
                .filter(str -> str.replaceAll("[^AEIOUaeiou]", "").length() == 2)
                .toList();
        System.out.println(list);

    }
}
