package practisequestions.leetcode;


//binary search is the divide and search which reduce the time complexity to O(logn)... and here we return the found index,,,
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 7, 10, 25};
        int target = 2;
        System.out.println(searchElement(nums, target));
    }

    public static int searchElement(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // or for the simple input just use the mid = rt+lft/2
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
