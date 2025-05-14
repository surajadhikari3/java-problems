package practisequestions.streams.should.look.once;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagramsFromList {
    //anagram is the pair of word from which exact character the another meaningful word can be formed.....
    public static void main(String[] args) {
        String[] s = {"pat", "tap", "pan", "nap", "Team", "tree", "meat"};

//        Map<List<String>, List<String>> collect = Arrays.stream(s)
//                .collect(Collectors.groupingBy(x -> Arrays.stream(x.toLowerCase().split("")).sorted().collect(Collectors.toList())));
//        System.out.println(collect.values());

//        Map<List<String>, List<String>> collect = Arrays.stream(s).collect(Collectors.groupingBy(a -> Arrays.stream(a.toLowerCase().split("")).sorted().toList()));
//        System.out.println(collect);

        Map<List<String>, List<String>> collect = Arrays.stream(s).collect(Collectors.groupingBy(x -> Arrays.stream(x.toLowerCase().split("")).sorted().toList()));
        System.out.println("collect" + collect.values());

    }
}