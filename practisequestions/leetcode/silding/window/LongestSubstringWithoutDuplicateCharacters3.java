package practisequestions.leetcode.silding.window;

/*
Given a string s, find the length of the longest substring without duplicate characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
* */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutDuplicateCharacters3 {

    public static void main(String[] args) {
//        String  s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
        String s = "au";
        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        int maxCount = 0;

        if(s.length() == 1) return 1;
        while(i < s.length()) {
            if (set.add(s.charAt(j))) {
               j = Math.min(j+1, s.length()-1);
            } else {
                maxCount = Math.max(set.size(), maxCount);
                set.remove(s.charAt(i));
                i++;
            }
        }

        return maxCount;
    }

}
