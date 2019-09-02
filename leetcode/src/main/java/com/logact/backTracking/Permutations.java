package com.logact.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: logact
 * @date: Created in 2019/9/2 14:42
 * @description:
 *easy
 * 全排列
 */
public class Permutations {
    /**
     * 方法一：
     * 由于没有重复的元素直接用在已经生成的list中寻找是否有重复的即可
     */
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list=new ArrayList<Integer>();
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        helper(nums,list,res);
        return res;
    }
    private void helper(int[]nums,List<Integer> list,List<List<Integer>>res){
        if(list.size()==nums.length){
            res.add(list);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }else{
                List copy=new ArrayList<Integer>(list);
                copy.add(nums[i]);
                helper(nums,copy,res);
            }
        }
    }
    /**
     * 方法二
     * 采用交换的方法
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0)return res;
        helper(nums,0,res);
        return res;
    }
    private void helper(int[]nums,int n,List<List<Integer>>res){
        if(n==nums.length-1){
            List<Integer> list=new ArrayList<Integer>();
            for(int e:nums){
                list.add(e);
            }
            res.add(list);
        }
        for(int i=n;i<nums.length;i++){
            swap(nums, n, i);
            helper(nums, n + 1, res);
            swap(nums, n, i);
        }
    }
    private void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


}
