package practisequestions.leetcode.LinkedList;

import java.util.ArrayList;

public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1, 5);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tmpNode = new ListNode(Integer.MIN_VALUE);
        ListNode holder = tmpNode;
        while (list1 != null || list2 != null) {
            if (list1.val > list2.val) {
                holder.next = list1;
                list1 = list1.next; //move the pointer of the next node linkedList...
            } else {
                holder.next = list2;
                list2 = list2.next;
            }
            holder = holder.next; // now we move th pointer of the node we created..
        }
        return holder.next;
    }
}
