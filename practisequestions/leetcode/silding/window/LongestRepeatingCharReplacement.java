package practisequestions.leetcode.silding.window;

import java.util.HashMap;

public class LongestRepeatingCharReplacement {

    public static void main(String[] args) {
//        String s = "AAABABB";
        String s = "XYYX";
//        String s = "AAAA";
        int k = 2;

        System.out.println(characterReplacement(s, k));
    }

    //Here the concept we keep on add and get the max character count but if the window is invalid we shrink the window from left and decrement the character from map.
    public static int characterReplacement(String s, int k) {

//        window = rt-lft+1;
        int lft = 0;
        int maxLength = 0;
        int maxCount = 0;
        int countSetter = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int rt = 0; rt < s.length(); rt++) {
            countSetter = map.getOrDefault(s.charAt(rt), 0) + 1;
            map.put(s.charAt(rt), countSetter);
            maxCount = Math.max(maxCount, countSetter);

            //if the window is invalid we will shrink the window from lft and decrement the lft character count....
            if ((rt - lft + 1) - maxCount > k) {
                map.put(s.charAt(lft), map.get(s.charAt(lft)) - 1);
                lft++;
            }

            maxLength = Math.max((rt - lft + 1), maxLength);
        }

        return maxLength;
    }

}
