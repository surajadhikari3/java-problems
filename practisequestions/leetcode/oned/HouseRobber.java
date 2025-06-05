package practisequestions.leetcode.oned;

import java.io.BufferedReader;

public class HouseRobber {
    public static void main(String[] args) {
        int[] input = {2, 9, 8, 3, 6};
        System.out.println(rob1(input));
    }


    //Time complexity --> 0(n)
    //Space complexity --> 0(n)
    //Even though its space complexity is doing for understanding........
    public static int rob1(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]); //If the input array is of the length 2 then if the first is max have to return the max so doing this........
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    //Time compelxity --> 0(n)
    //Space complexity --> 0(1)
    public static int rob2(int[] nums) {
        int rob1 = nums[0];
        int rob2 = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max((rob1 + nums[i]), rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }

}
