package practisequestions.streams.practise;

import java.util.Arrays;

public class ProductOfFirstTwoElement {
    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 9, 2, 4};
        Integer reduce = Arrays.stream(arr).boxed().limit(2).reduce(1, (a, b) -> a * b);
        System.out.println(reduce);
    }
}
