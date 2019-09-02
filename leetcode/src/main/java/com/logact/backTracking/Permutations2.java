package com.logact.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: logact
 * @date: Created in 2019/9/2 15:07
 * @description:
 * medium
 * 全排列二：含有重复的数字。
 */
public class Permutations2 {
    /**
     * method1:在permutation1的基础下加上交换条件：
     * 只在两个下标所指示的值不相同或者当前下标等与初始下标的时候才交换
     * 但是很遗憾这种方法在特殊情况下失灵了
     * 例如：[2,2,1,1]在交换1，3位2，4位不动的情况下（1,2,2,1）与交换1，4位和交换2，3位的情况是相同的。
     * @param nums
     * @return
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
            if(i==n||nums[i]!=nums[n]){
                swap(nums,n,i);
                helper(nums,n+1,res);
                swap(nums,n,i);
            }


        }
    }
    private void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


    /**
     * method 2使用遇到重复先排序。
     * 排序之后还没运行成功的原因是这个递归过程没有让数组的装填保持一致。
      * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0)return res;
        Arrays.sort(nums);
        helper1(nums,0,res);
        return res;
    }
    private void helper1(int[]nums,int n,List<List<Integer>>res){
        if(n==nums.length-1){
            List<Integer> list=new ArrayList<Integer>();
            for(int e:nums){
                list.add(e);
            }
            res.add(list);
            return;
        }
        for(int i=n;i<nums.length;){
            swap(nums,n,i);
            Arrays.sort(nums,n+1,nums.length-1);
            helper1(nums,n+1,res);
            Arrays.sort(nums,n+1,nums.length-1);
            swap(nums,n,i);
            i++;
            while(i<nums.length&&nums[i]==nums[i-1]){
                i++;
            }
        }
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.remove(0);
        int[] array= {1,0, 10, 9, 8, 7, 6, 5, 4, 3};
        System.out.println("before");
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println("after");
        Arrays.sort(array,3,10);
        for (int i : array) {
            System.out.println(i);
        }
    }
    /**
     * 改进方法不拷贝list
     * 对list状态进行维护。
     */
    public List<List<Integer>> permuteUnique3(int[] nums) {
        boolean[] visited=new boolean[nums.length];//这里可以用位图来节省空间
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer>list=new ArrayList<Integer>();
        help(res,list,visited,nums);
        return res;
    }
    private void help(List<List<Integer>>res,List<Integer> list,boolean[]visited,int[] nums){
        if(list.size()==nums.length){
            System.out.println("**********************");
            System.out.println("size:"+list.size());
            System.out.println("length:"+nums.length);
            System.out.println("the number of the list");
            for(int e:list){
                System.out.println("e:"+e);
            }
            List<Integer> copy=new ArrayList<Integer>();
            for(int e:list){
                copy.add(e);
            }

            res.add(copy);
            System.out.println("res.size:"+res.size());
            System.out.println("**********************");
            return;
        }
        for(int i=0;i<nums.length;){
            if(!visited[i]){
                list.add(nums[i]);
                visited[i]=true;
                help(res,list,visited,nums);
                //以下的两句都是为了在回溯算法中的状态重置。
                list.remove(list.size()-1);
                visited[i]=false;
                i++;
                while(i<nums.length&&nums[i]==nums[i-1]){
                    i++;
                }
            }else{
                i++;
            }
        }
    }

}
