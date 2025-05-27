package practisequestions.leetcode.arraysnhashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3};
        int k = 2;
        topKFrequent(nums, k);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        return Arrays.stream(nums).boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
