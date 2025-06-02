package practisequestions.leetcode.tree;


import java.util.LinkedList;
import java.util.Queue;

import static practisequestions.leetcode.tree.TreeNode.buildTreeFromArray;

public class InvertBinaryTree {


    public static void main(String[] args) {
        Integer[] root = {1, 2, 3, 4, 5, 6, 7};
        TreeNode treeNode = buildTreeFromArray(root);
        invertTree(treeNode);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null; //base condition as we are sending the left and right node which is null if it is child node...
        }
        //Logic to swap the nodes
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        //Recursive call on both left and right node...
        invertTree(root.left);
        invertTree(root.right);

        System.out.println(root);
        return root;
    }
}

