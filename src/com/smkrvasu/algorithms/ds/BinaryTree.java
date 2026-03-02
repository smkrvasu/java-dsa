package com.smkrvasu.algorithms.ds;

public class BinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        inorderPrint(root);
    }

    private static void inorderPrint(TreeNode root) {
        if (root != null) {
            inorderPrint(root.left);
            System.out.println(root.val);
            inorderPrint(root.right);
        }
    }
}