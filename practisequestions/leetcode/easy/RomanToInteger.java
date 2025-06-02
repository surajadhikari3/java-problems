package practisequestions.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += map.get(s.charAt(i));
            int index = Math.min(i+1, s.length()-1);
            if (s.charAt(i) == 'I' && (s.charAt(index) == 'V' || s.charAt(index) == 'X')) {
                sum -=2;
            } else if (s.charAt(i) == 'X' && (s.charAt(index) == 'L' || s.charAt(index) == 'C')) {
                sum -=20;
            }else if (s.charAt(i) == 'C' && (s.charAt(index) == 'D' || s.charAt(index) == 'M')) {
                sum -=200;
            }


        }
        return sum;
    }
}
