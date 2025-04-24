package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindTheIntersectionOfTwoList {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list1 = Arrays.asList(3, 5, 6, 7);


        //1st Method....
//        List<Integer> commonElement = list.stream().filter(x-> list1.contains(x)).toList();
        List<Integer> commonElement = list.stream().filter(list1::contains).toList();

        //2nd Method....
        List<Integer> list2 = Stream.concat(list.stream(), list1.stream()).collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.println(list2);
        System.out.println(commonElement);

    }
}
