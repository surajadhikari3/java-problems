package practisequestions.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CountOfParticularSubstring {
    public static void main(String[] args) {
        String s = "byebyeBirdiebyecheccxcdfdfdsfdsfbye";
        String check = "bye";

        long count1 = IntStream.range(0, s.length() - 2) //since we are doing the x+3 which is exclusive to prevent the array out of bound exception we do s.length()-2
                .filter(x -> s.substring(x, x + 3).equals(check))
                .count();
        System.out.println(count1);
    }
}
