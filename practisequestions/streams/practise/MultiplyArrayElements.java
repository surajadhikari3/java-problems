package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.function.Consumer;

public class MultiplyArrayElements {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5};
        Integer reduce = Arrays.stream(integers).reduce(1, (a, b) -> a * b);
        System.out.println(reduce);
    }
}
