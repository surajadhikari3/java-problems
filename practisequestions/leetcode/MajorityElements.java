package practisequestions.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElements {
    public static void main(String[] args) {
        findMajorityElementsWithoutStream();
    }

    public static int findMajorityElementsWithoutStream() {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        AtomicInteger element = new AtomicInteger();
        Map<Integer, Integer> count = new HashMap<>();
        for (int numb : nums) {
            count.put(numb, count.getOrDefault(numb, 0) + 1);
            if (count.get(numb) > nums.length / 2) {
                System.out.println(numb);
                return numb;
            }
        }
        return -1;
    }

    public static int findMajorityElements() {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        Integer i = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                entrySet().stream().filter(x -> x.getValue() > nums.length / 2)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println(i);
        return i;
    }
}
