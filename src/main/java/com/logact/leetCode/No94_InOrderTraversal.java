package com.logact.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The in order traversal of binary tree
 * no.94
 * medium
 */
public class No94_InOrderTraversal {


    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * recursion version
     *
     * @param root
     * @return
     */

    public List<Integer> inorderTraversal_1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        help(result, root);
        return result;
    }

    private void help(List<Integer> res, TreeNode root) {
        if (root != null) {
            help(res, root.left);
            res.add(root.val);
            help(res, root.right);
        }
    }

    /**
     * explicit stack version
     */
    public List<Integer> inorderTraversal_2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        help1(result, root);
        return result;
    }

    private void help1(ArrayList<Integer> result, TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) return;
        stack.push(root);
        root = root.left;

        while ((root!=null) || (!stack.isEmpty())) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right= new TreeNode(3);
        root.left.left= new TreeNode(4);
        root.left.right= new TreeNode(5);
        root.right.left= new TreeNode(6);
        root.right.right= new TreeNode(7);

        No94_InOrderTraversal test = new No94_InOrderTraversal();
        List<Integer> list = test.inorderTraversal_2(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
