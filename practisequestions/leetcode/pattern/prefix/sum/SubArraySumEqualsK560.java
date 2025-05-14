package practisequestions.leetcode.pattern.prefix.sum;

import java.util.HashMap;
import java.util.Map;
/*
Core Insight:
Let’s say prefixSum[i] is the sum of elements from index 0 to i.

Now for any subarray from index i to j, the sum is:

prefixSum[j] - prefixSum[i-1]
So, to find subarray sum = k, we want:

prefixSum[j] - prefixSum[i-1] = k
→ prefixSum[i-1] = prefixSum[j] - k
So if we know how many times a prefix sum prefixSum[j] - k has occurred before, we can count it as a valid subarray.


* */
public class SubArraySumEqualsK560 {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1); //prefixSum, count
        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum+= nums[i];

            if(map.containsKey(prefixSum - k)){ // logic here is that subarray with sum k exists ending at this index..
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) +1 );

        }
        return count;

    }
}
