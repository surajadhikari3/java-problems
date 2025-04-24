package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.List;

public class ConvertListToItsSquare {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> square = list.stream().map(x -> x * x).toList();
        System.out.println(square);
    }
}
