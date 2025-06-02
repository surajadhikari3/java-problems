package practisequestions.leetcode.oned;

public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        System.out.println("length"+ cost.length);
        for (int i = cost.length-3; i >= 0; i--) {
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]);

    }


    public static void main(String[] args) {
        int[] cost = {1, 2, 3};
        System.out.println(minCostClimbingStairs(cost));
    }
}
