package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReArrangeInHighestAndLowest09 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 42, 5};
        Arrays.stream(arr).boxed().sorted().forEach(System.out::println);
        Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
