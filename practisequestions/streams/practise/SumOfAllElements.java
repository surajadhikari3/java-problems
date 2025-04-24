package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

//Remember sum is operated in the primitive data type so have to do mapToInt()
//If we operate in the wrapper class we can use the reduce with the initial value of 0..
//Also while performing the arthemetic operation it is better to do in primitive type as it saves the memory and also the operation is fast..............
public class SumOfAllElements {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = list.stream().mapToInt(x -> x).sum();
        System.out.println(reduce);
    }
}
