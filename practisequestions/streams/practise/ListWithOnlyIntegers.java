package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.List;

public class ListWithOnlyIntegers {
    public static void main(String[] args) {
        String[] s = {"abc", "123", "456", "xyz"};
        List<Integer> list = Arrays.stream(s).filter(numb -> numb.matches("\\d+"))
                .map(Integer::valueOf)
                .toList();
        System.out.println(list);
    }
}
