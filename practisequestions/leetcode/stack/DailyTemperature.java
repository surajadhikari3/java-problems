package practisequestions.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {
        int[] temperatures = {30, 38, 30, 36, 35, 40, 28};
//        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
        System.out.println(Arrays.toString(withLinearTimeComplexity(temperatures)));

//         {1,4,1,2,1,0,0};
    }

    //brute force approach with O(n2)
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] highTempDiff = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    highTempDiff[i] = j - i;
                    break;
                } else if ((temperatures[j] <= temperatures[i]) && j == temperatures.length - 1) {
                    temperatures[i] = 0;
                }
            }
        }
        return highTempDiff;
    }


    //this is solved by the monotonic stack problem...
    public static int[] withLinearTimeComplexity(int[] temperatures) {
        int[] highTempDiff = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        //If i want to fill the array with the default value then i can use the Arrays.fill(highTempDiff, defaultValue)..
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                highTempDiff[index] = i - index;
            }
            stack.push(i);
        }
        return highTempDiff;
    }

}