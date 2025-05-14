package practisequestions.leetcode;

import java.util.Arrays;
import java.util.Map;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer = Math.min(0, nums2.length-1);
        int max = Integer.MIN_VALUE;

//        for(int i = 0; i < nums1.length; i++){
//            if(nums1[i] == 0){
//                nums1[i] = nums2[pointer];
//                pointer++;
//            }
//        }

        if(nums2.length==0){
            return;
        }
        System.out.println("lenght is " + nums2.length);

        for(int i = 0; i < nums1.length; i++){

            if(nums1[i]> nums2[pointer]){
                nums1[i+1] = nums1[i];
                nums1[i] = nums2[pointer];
                if(pointer == nums2.length-1)
                    break;
                pointer++;
            }
            if(nums1[i] == 0){
                nums1[i] = nums2[pointer];
                pointer++;
            }
        }


        System.out.println("before " + Arrays.toString(nums1));

//        Arrays.stream(nums1).sorted().forEach(System.out::println);

    }


    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = {2, 5, 6};
//        int n = 3;
        int[]  nums1 = {4,5,6,0,0,0}; int m = 3; int[] nums2 = {1,2,3}; int n = 3;
        merge(nums1, m, nums2, n);
    }
}