package practisequestions.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveElementsFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums = {1,1,2};
        firstAttempt();

        }

    public static int firstAttempt(){
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Set<Integer> integers = new HashSet<>();
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (integers.add(nums[i])) {
                nums[counter] = nums[i];
                counter++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return integers.size();
    }
}
