package practisequestions.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> findSubset(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backTrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);                           //choose
            backTrack(i + 1, nums, current, result);     //Explore
            current.remove(current.size() - 1);        //Un-choose (BackTrack)
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.findSubset(new int[]{1, 2, 3}));
    }
}
