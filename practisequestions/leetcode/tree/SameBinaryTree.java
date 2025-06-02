package practisequestions.leetcode.tree;

import static practisequestions.leetcode.tree.TreeNode.buildTreeFromArray;

public class SameBinaryTree {

    public static void main(String[] args) {
        Integer[] p = {1, 2, 3};
        Integer[] q = {1, 2, 3};
        TreeNode treeNode = buildTreeFromArray(p);
        TreeNode treeNode1 = buildTreeFromArray(q);
        System.out.println(isSameTree(treeNode, treeNode1));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val == q.val) {
            return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
        }
        return false;
    }

}