package practisequestions.leetcode.two.pointer;

import java.util.Arrays;

public class TwoSumNeet {
    public static void main(String[] args) {
//        int[] nums={-1,-2,-3,-4,-5};
//        int target = -8;
        int[] nums={3,2,3};
        int target=6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int[] pair = new int[2];
        while(i < j){
            if((nums[i] + nums[j])== target) {
                pair[0] = i;
                pair[1] = j;
                return pair;
            } else if(nums[i] + nums[j] > target){
                j--;
            } else{
                i++;
            }
        }

        return pair;

    }
}
