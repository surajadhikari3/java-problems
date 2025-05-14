package practisequestions.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingWithTwiceAppearance {
    public static void main(String[] args) {
//        int[] nums = {0, 0, 0, 1, 1, 1, 2, 3, 3};
        int[] nums = {0,1,1,1,1,2,3,3};
        System.out.println(duplicateForTwice(nums));
    }


    //just you have to check the eligibility to put in the array by simply compaing it with i-2 before two index element as two elements max is allowed..
    //base cas is first two element which we do not have to check it sincee we are doing i-2 for first two element it will have array out of bound error..
    private static int duplicateForTwice(int[] nums) {
        int i = 0;
        for(int numb: nums){
            if( i < 2 || numb != nums[i-2]){
                nums[i] = numb;
                i++; //here nums[i++] is equivalent to the nums[i] and i++;
            }
        }
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
        return i;
    }

//        Map<Integer, Long> collect = Arrays.stream(nums)
//                .boxed()
//                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
//        System.out.println(collect);

//        collect.entrySet().stream().


}
