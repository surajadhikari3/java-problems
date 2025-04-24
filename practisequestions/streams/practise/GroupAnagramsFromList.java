package practisequestions.streams.practise;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagramsFromList {
    //anagram is the pair of word from which exact character the another meaningful word can be formed.....
    public static void main(String[] args) {
        String[] s = {"pat", "tap", "pan", "nap", "Team", "tree", "meat"};

//        Map<List<String>, List<String>> collect = Arrays.stream(s)
//                .collect(Collectors.groupingBy(x -> Arrays.stream(x.toLowerCase().split("")).sorted().collect(Collectors.toList())));
//        System.out.println(collect.values());

        Map<List<String>, List<String>> collect = Arrays.stream(s).collect(Collectors.groupingBy(a -> Arrays.stream(a.toLowerCase().split("")).sorted().toList()));
        System.out.println(collect.values());
    }
}