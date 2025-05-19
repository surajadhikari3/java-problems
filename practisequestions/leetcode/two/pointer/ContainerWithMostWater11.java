package practisequestions.leetcode.two.pointer;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        int area;
        while (i < j) {
            area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);
            int i1 = (height[i] - height[j] > 0) ? j-- : i++; //just moving the lowe height and keeping the highest height constant at a time
        }
        return maxArea;
    }
}
