package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.List;

public class FindKthSmallestElement {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(7, 1, 6, 2, 1, 3, 4, 5);
        List<Integer> list = Arrays.asList(1, 5, 6, 7, 8, 9);
        int k = 2;

//        156789
        List<Integer> list1 = list.stream().sorted().skip(k - 1).toList();
        System.out.println(list1);
    }
}
