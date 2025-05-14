package practisequestions.leetcode;

import java.util.Arrays;

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
* */
public class RotateArray {


    //steps first rotate the array 0 to nums.length-1 and then 0 to k-1 and k-1 to length-1;
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int length = nums.length;
        rotateArray(nums, 0, length - 1);
        rotateArray(nums, 0, k - 1);
        rotateArray(nums, k, length - 1);
    }



    public static void rotateArray(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end --;
        }
        System.out.println(Arrays.toString(nums));
    }
}
