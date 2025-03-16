package practisequestions;

import java.util.Arrays;

public class ReverseArray {

    public int[] reverseArray(int[] arr){
        int[] reversedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArray[i] = arr[arr.length - i-1];
        }
        return reversedArray;
    }

    public static void main(String[] args) {
        int[] input = {10, 4, 25, 6 ,3};
        System.out.println(Arrays.toString(new ReverseArray().reverseArray(input)));
    }
}
