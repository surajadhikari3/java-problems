package practisequestions.leetcode.oned;

import java.util.HashMap;
import java.util.Map;

public class climbingStairs {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int findFibonacci(int n) {
        if (n == 1) return 1; //base conditions for the stair case..
        if (n == 2) return 2;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = findFibonacci(n - 1) + findFibonacci(n - 2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        memo.clear();
        int n = 4;
        System.out.println(findFibonacci(n));
    }
}
