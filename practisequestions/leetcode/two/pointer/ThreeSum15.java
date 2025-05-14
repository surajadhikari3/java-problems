package practisequestions.leetcode.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {

    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {0,1,1};
//        int[] nums = {0, 0, 0, 0};
        int[] nums = {-2, 0, 1, 1, 2};
        System.out.println(threeSum(nums));
//        Output: [[-1,-1,2],[-1,0,1]]
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSum = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue; //skiping the duplicates here
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if ((nums[i] + nums[j] + nums[k]) == 0) {
                    threeSum.add(List.of(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++; // for skipping the duplicates
                    while (j < k && nums[k] == nums[k + 1]) k--; // for skipping the k duplicates as we don't want to add duplicates  into the triplets
                    j++; // to move into the next iteration...
                    k--;
                } else if ((nums[i] + nums[j] + nums[k]) > 0) {
                    k--;
                } else if ((nums[i] + nums[j] + nums[k]) < 0) {
                    j++;
                }
            }

        }
        return threeSum;
    }
}
