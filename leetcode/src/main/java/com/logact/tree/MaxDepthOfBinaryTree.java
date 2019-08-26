package com.logact.tree;

import com.logact.tool.TreeNode;

/**
 *easy
 *solve the problem with one statement
 *
 */
public class MaxDepthOfBinaryTree {
    class Solution {
        public int maxDepth(TreeNode root) {
            if(root==null)return 0;
            int rightDepth=maxDepth(root.right);
            int leftDepth=maxDepth(root.left);
            return Math.max(rightDepth,leftDepth)+1;
        }
    }
}
