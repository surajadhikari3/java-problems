package practisequestions.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(carFleet(target, position, speed));
    }

    public static int carFleet(int target, int[] position, int[] speed) {

        //Sorting the position in descending order and have to sort the speed as well according to it..
        int[][] cars = new int[position.length][2];

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        for (int i = 0; i < position.length; i++) {
            System.out.println("Position: " + cars[i][0] + ", Speed: " + cars[i][1]);
            double time = (double) (target - cars[i][0]) / cars[i][1];
            if (i == 0) {
                stack.push(time);
            } else if (time > stack.peek()) {
                stack.push(time);
            }
        }
        return stack.size();
    }
}
