package practisequestions.leetcode.arraysnhashing;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
//        int[] nums = {2, 20, 4, 10, 3, 4, 5};
        int[] nums = {0, 3, 2, 5, 4, 6, 1, 1};

        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int maxCount = 1;
        int counter = 1;
        if (nums.length == 1) return 1;

        for (int i = 0; i < nums.length; i++) {
            int tracker = Math.min(i + 1, nums.length - 1);
            if (nums[tracker] - nums[i] == 1 || nums[tracker] - nums[i] == 0) {
                if (nums[tracker] - nums[i] == 1) {
                    counter++;
                    maxCount = Math.max(maxCount, counter);
                }
            } else {
                counter = 1;
            }
        }
        return maxCount;
    }
}
