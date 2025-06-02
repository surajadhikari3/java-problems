package practisequestions.leetcode.LinkedList;

import org.w3c.dom.Node;

public class ReverseLinkedList {

    static class ListNode {
        int val;

        @Override
        public String toString() {
            return "ListNode{" + "val=" + val + ", next=" + next + '}';
        }

        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] head = {0, 1, 2, 3};
        for (int i = 0; i < head.length; i++) {
            ListNode listNode = reverseList(new ListNode(head[i]));
//            System.out.println(listNode);
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = previous;
            previous = current;
            current = tmp;
        }
        return previous;
    }
}
