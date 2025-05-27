package practisequestions.leetcode.arraysnhashing;

import java.util.Arrays;
import java.util.PropertyResourceBundle;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] mul = new int[nums.length];
        prefix[0] = nums[0];
        postfix[nums.length - 1] = nums[nums.length - 1];

        //finding the prefix multiplication and postfix multiplication........
        //Have to run the loop one less time as the initial first and last value is same.........
        for (int i = 0; i < nums.length - 1; i++) {
            prefix[i + 1] = prefix[i] * nums[i + 1];
            postfix[nums.length - i - 2] = postfix[nums.length - i - 1] * nums[nums.length - i - 2];
            System.out.println("pre" + Arrays.toString(prefix));
            System.out.println("post" + Arrays.toString(postfix));
        }

        for (int i = 0; i < nums.length; i++) {
            int left = (i == 0) ? 1 : prefix[i - 1];  //For the first element we dont have prefix
            int right = (i == nums.length - 1) ? 1 : postfix[i + 1]; //For the last element we dont have back postfix
            mul[i] = left * right;
        }
        return mul;
    }
}
