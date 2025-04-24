package practisequestions.leetcode;

import java.util.Arrays;

public class RemoveElement {

    //Do not use the stream as it will create the copy of the array and in the leet code it is passing by value


    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
//        removeElementFirstApproach(nums, val);
        int k = removeElementOptimalSolution(nums, val);
        System.out.println("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.println(nums[i] + " ");
        }
    }



    public static int removeElementOptimalSolution(int[] nums, int val){
        int pointer = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] != val){
                nums[pointer] = nums[i];
                pointer ++;
            }
        }
        System.out.println("check" + Arrays.toString(nums));
        return pointer;
    }








    public static int removeElementFirstApproach(int[] nums, int val) {

        for(int i = 0;i < nums.length; i++){
            if(nums[i] == val){
                nums[i] = 9; // re
            }
        }

        System.out.println("before" + Arrays.toString(nums));


        for (int i = nums.length-2; i >= 0 ; i--) {
            if(nums[i] == 9){
                //to keep the track of the last element
                int temp = nums[nums.length-1];
                nums[nums.length-1] = 9;

                for (int j = i; j < nums.length-2; j++) {
                    nums[j] = nums[j+1];
                }
                nums[nums.length-2] = temp;
            }
        }


        System.out.println("After" + Arrays.toString(nums));
        long count = Arrays.stream(nums).filter(x -> x != 9).count();
        System.out.println("count" + count);
        return (int) count;
    }
}
