package practisequestions.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] input = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(input));
    }


    //Time complexity --> O(NLogN∗L)WhereNIsTheNumberOfStringsAndLIsTheAverageStringLength
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs); //Sorted on the lexical order not on the basis of the length of the string
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int id = 0;
        while (id < s1.length() && id < s2.length()) {
            if (s1.charAt(id) == s2.charAt(id)) {
                id++;
            } else {
                break;
            }
        }

      return s1.substring(0, id);
    }
}
