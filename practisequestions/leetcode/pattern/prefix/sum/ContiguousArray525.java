package practisequestions.leetcode.pattern.prefix.sum;

import java.util.HashMap;
import java.util.Map;

// the key concept here is that change the 0 to -1 and find the prefix sum
// if the prefix sum is same then find the length(based on the index) which is the subaray with equal number of ones and  zeros
// but there might be the equal number of others sum keep the max of the same length which is the max length


public class ContiguousArray525 {

    public static void main(String[] args) {
//        int[] nums = {0, 1, 1, 1, 1, 1, 0, 0, 0};

        int[] nums = {0,1,1,1,1,1,0,0,0};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); //Base case: sum 0 at index -1 logic is we are keeping the track of the difference in the specific index.
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum)); // here if the prefix sum is 0 that already presents then we are getting the length of it
                //means we found the equal number of 0 and 1 so using the prefix sum to find the length
            } else {
                map.put(sum, i); //store the first time the sum occurred.
            }
        }
        return maxLength;
    }

}
