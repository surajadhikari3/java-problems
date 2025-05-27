package practisequestions.leetcode.arraysnhashing;

/*
Group Anagrams
Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: strs = ["act","pots","tops","cat","stop","hat"]

Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
Example 2:

Input: strs = ["x"]

Output: [["x"]]


 * */

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        groupAnagrams(strs);

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
//        Map<List<String>, List<String>> collect = Arrays.stream(strs).collect(Collectors.groupingBy(x -> Arrays.stream(x.toLowerCase().split("")).sorted().toList()));
//
//        System.out.println(collect.values());
//        List<List<String>> result = new ArrayList<>(collect.values());
//        return result;

        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] charArray = str.toLowerCase().toCharArray();
            Arrays.sort(charArray);
            String key = charArray.toString();
            map.computeIfAbsent(key, k-> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    //Both of them have the timeComplexity of O(N

    /*

    ✅ Equivalent traditional (verbose) code:
if (!map.containsKey(key)) {
    map.put(key, new ArrayList<>());
}
    map.get(key).add(str);
💡   So computeIfAbsent is just a shorthand for the if (!containsKey) + put() pattern.
    * */

}
