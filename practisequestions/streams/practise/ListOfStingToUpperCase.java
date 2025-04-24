package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.List;

public class ListOfStingToUpperCase {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("breaking bad", "game of thrones");
        List<String> list1 = list.stream().map(x -> x.toUpperCase()).toList();
        System.out.println(list1);
    }
}
