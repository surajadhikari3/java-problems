package practisequestions.streams.should.look.once;

import java.util.Arrays;
import java.util.Comparator;

public class ReArrangeInHighestAndLowest09 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 42, 5};
        Arrays.stream(arr).boxed().sorted().forEach(System.out::println);
        Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
