package practisequestions.leetcode;

public class JumpGameII {

    public static void main(String[] args) {
        int[] input1 = {2,3,1,1,4};
        int[] input2 = {2,4,1,2,3,1,1,2};
        System.out.println(jump(input1));
    }

    public static int jump(int[] nums) {

        //[2,3,1,1,4]

        int currentRange = 0;
        int maxCoverage = 0; // we want to jump to the max  steps minimizing the steps...
        int jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //in each iteration within the range we are keeping the track of max steps minimizing the steps..
           maxCoverage =  Math.max(maxCoverage, i + nums[i]); // gives the track of max value within the range to jump
           if(i == currentRange){
               jumps ++;
               currentRange = maxCoverage;
           }
        }
        return jumps;
    }
}
