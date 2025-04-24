package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.List;

public class CalculateTheAverage {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //changing to primitive double type first
        double sum = list.stream().mapToDouble(x ->(double) x).average().getAsDouble();
        System.out.println(sum);
    }
}
