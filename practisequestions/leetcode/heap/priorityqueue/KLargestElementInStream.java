package practisequestions.leetcode.heap.priorityqueue;

import java.util.PriorityQueue;

public class KLargestElementInStream {


    //priority queue is the minHeap in the java............

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k;

    public KLargestElementInStream(int k, int[] nums) {
        this.k = k;
        for (int numb : nums) {
            add(numb);
        }
    }

    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll(); //return the smallest element keeping the top 3 elemnent
        }

        return minHeap.peek(); // out of top element it returns the lowest element..
    }

    public static void main(String[] args) {
        KLargestElementInStream kLargestElementInStream = new KLargestElementInStream(3, new int[]{4, 5, 8, 2});
        System.out.println(kLargestElementInStream.add(3));
        System.out.println(kLargestElementInStream.add(5));
        System.out.println(kLargestElementInStream.add(10));
        System.out.println(kLargestElementInStream.add(9));
        System.out.println(kLargestElementInStream.add(4));
    }

}
