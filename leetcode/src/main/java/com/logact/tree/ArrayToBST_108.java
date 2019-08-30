package com.logact.tree;

import com.logact.tool.TreeNode;

/**
 * @author: logact
 * @date: Created in 2019/8/30 15:15
 * @description:
 * easy
 */
public class ArrayToBST_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0)return null;
        else return help(nums,0,nums.length-1);
    }
    private TreeNode help(int[]nums,int s,int e){
        if(s>e)return null;
        if(s==e)return new TreeNode(nums[e]);
        int mid = (s+e)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=help(nums,s,mid-1);
        root.right=help(nums,mid+1,e);
        return root;
    }
}
