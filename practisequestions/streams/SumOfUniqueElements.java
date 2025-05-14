package practisequestions.streams;

import java.sql.Array;
import java.util.Arrays;

public class SumOfUniqueElements {
    public static void main(String[] args) {
        int[] arr = {2,5,5,3,9,10};

        int sum = Arrays.stream(arr).distinct().reduce(0, Integer::sum);
        System.out.println(sum);
    }

}
