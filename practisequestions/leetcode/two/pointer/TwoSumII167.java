package practisequestions.leetcode.two.pointer;

import java.util.Arrays;

public class TwoSumII167 {

    public static void main(String[] args) {
      int[] numbers =  {2,7,11,15};
        int target = 9;

//        int[] numbers={-1,-2,-3,-4,-5};
//        int target = -8;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] indexes = new int[2];
        int j = numbers.length-1;
        int i = 0;
        while (i < j){
            if(numbers[i] + numbers[j] == target){
                indexes[0] = i+1;
                indexes[1] = j+1;
                return indexes;
            } else if(numbers[i] + numbers[j] > target){
                j--;
            } else{
                i++;
            }
        }
        return indexes;
    }
}
