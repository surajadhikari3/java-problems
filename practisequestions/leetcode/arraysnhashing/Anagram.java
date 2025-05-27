package practisequestions.leetcode.arraysnhashing;

import java.util.Arrays;
import java.util.Objects;

public class Anagram {

    public static void main(String[] args) {
        String s = "racecar";
        String t = "carrace";
        System.out.println(isAnagram(s, t));
    }

    /*
    The concept here is we are incrementing in the specific ascii field and other is decrementing in the same field.And if it is anagram it should be zero which we are checking
    * */
    public static boolean isAnagram(String s, String t) {
//           String[] s1 = s.split("");
//           Arrays.sort(s1);
//            System.out.println(Arrays.toString(s1));
//            String[] t1 = t.split("");
//            Arrays.sort(t1);
//            System.out.println(Arrays.toString(t1));
//
//            for(int i=0; i < s.length(); i++){
//               if(!s1[i].equals(t1[i])) { //since it is the string we have to
//                   return false;
//               }
//            }
//            return true;


        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }

}
