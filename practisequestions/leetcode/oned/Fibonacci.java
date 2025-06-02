package practisequestions.leetcode.oned;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

   private static Map<Integer, Integer> memo = new HashMap<>();

    public static int findFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = findFibonacci(n - 1) + findFibonacci(n - 2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(findFibonacci(i));
        }
    }
}
