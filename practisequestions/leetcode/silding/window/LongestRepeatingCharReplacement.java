package practisequestions.leetcode.silding.window;

import java.util.HashMap;

public class LongestRepeatingCharReplacement {

    public static void main(String[] args) {
//        Input: s = "AAABABB", k = 1

//        Output: 5
    }

    public static int characterReplacement(String s, int k) {
        int lft = 0;
        int tr = 0;
        int windowLength = 1;
        int maxLength = 1;
        int highestFrequency = 1;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//            windowLength - map.get()

        }

        return 0;
    }
}
