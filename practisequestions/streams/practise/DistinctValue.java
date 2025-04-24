package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DistinctValue {
    public static void main(String[] args) {
        int[] arr = {5,0,1,2,8,7};
        Boolean isDistinct = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting())).values()
                        .stream().noneMatch(x-> x > 1);
        System.out.println(isDistinct);
    }
}
