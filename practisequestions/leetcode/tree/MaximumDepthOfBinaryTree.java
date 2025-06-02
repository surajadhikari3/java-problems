package practisequestions.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import static practisequestions.leetcode.tree.TreeNode.buildTreeFromArray;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        Integer[] root = {1, 2, 3, null, null, 4};
        TreeNode treeNode = buildTreeFromArray(root);
        maxDepthViaRecursion(treeNode);
    }

//    public static int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root); //it adds and does not throws the exception if it does not able to add the element
//        int depth = 0;
//        while (!queue.isEmpty()) {
//            int levelSize = queue.size();
//            for (int i = 0; i < levelSize; i++) {
//                TreeNode current = queue.poll();
//                assert current != null;
//                if (current.left != null) queue.offer(current.left);
//                if (current.right != null) queue.offer(current.right);
//            }
//            depth++;
//        }
//        return depth;
//    }

    public static int maxDepthViaRecursion(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepthViaRecursion(root.left), maxDepthViaRecursion(root.right));
    }
}
