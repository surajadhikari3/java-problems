package practisequestions.leetcode.silding.window;

/*
You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
Any answer with a calculation error less than 10-5 will be accepted.
Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
* */


import static java.lang.Math.round;

public class MaxAverageSubArray643 {

    public static void main(String[] args) {
//        int[] nums = {1, 12, -5, -6, 50, 3};
//        int k = 4;

        int[] nums = {9, 7, 3, 5, 6, 2, 0, 8, 1, 9};
        int k = 6;

        System.out.println(findMaxAverage(nums, k));
    }


    //This was my first raw approach
//    public static double findMaxAverage(int[] nums, int k) {
//        int i = 0;
//        int j = k - 1;
//        int maxSum = 0;
//        int sum = 0;
//
//        if(nums.length == 1){
//           return (double) nums[0];
//        }
//
//        for (int l = i; l <=j; l++) {
//            sum += nums[l];
//        }
//
//        maxSum = sum;
//        if(nums.length == k){
//            return (double) sum / k;
//        }
//
//        while (j < nums.length) {
//            if(j== nums.length-1) break;
//            sum = sum + nums[++j] - nums[i++];
//            maxSum = Math.max(maxSum, sum);
//            System.out.println("maxSum " + maxSum);
//        }
//
//
//       return (double) maxSum / k;
//
//    }


    //This is from looking the solutions....
    public static double findMaxAverage(int[] nums, int k) {

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;

    }
}

