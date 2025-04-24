package practisequestions.streams.practise;

import java.util.Arrays;

public class SumOfUniqueElements10 {
    public static void main(String[] args) {
        int[] arr = {1, 6, 7, 8 , 1, 1, 8, 8,7};
        Integer reduce = Arrays.stream(arr).distinct().sum();
        System.out.println(reduce);
    }
}
