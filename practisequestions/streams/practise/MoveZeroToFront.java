package practisequestions.streams.practise;

import java.util.*;
import java.util.stream.Collectors;


//Collectors.partitoningBy gives the map based on predicate only means it will group only on the base on true or false.....
public class MoveZeroToFront {

    public static void main(String[] args) {
        int[] arr = {5,0,1,0,8,0};

        //1st Approach
        List<Integer> zeros = Arrays.stream(arr).boxed().filter(x -> x == 0).toList();
        List<Integer> nonZeros = Arrays.stream(arr).boxed().filter(x -> x != 0).toList();

        List<Integer> zeroAndNonZeros = new ArrayList<>();
        zeroAndNonZeros.addAll(zeros);
        zeroAndNonZeros.addAll(nonZeros);
        System.out.println(zeroAndNonZeros);




        //2nd Approach
        Map<Boolean, List<Integer>> collect = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(x -> x != 0));
        System.out.println(collect);

        List<Integer> list = collect.values().stream().flatMap(Collection::stream).toList();
        System.out.println(list);

    }
}
