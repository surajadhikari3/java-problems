package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.List;

public class DistinctOddNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6,7, 8, 9, 9, 10);
        List<Integer> list1 = list.stream().filter(x -> x % 2 != 0).distinct().toList();
        System.out.println(list1);
    }
}
