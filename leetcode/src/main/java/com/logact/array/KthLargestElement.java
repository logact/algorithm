package com.logact.array;

/**
 * @author: logact
 * @date: Created in 2019/8/26 16:34
 * @description:
 * medium
 * error: 1.the the kth largest element is the kth min element
 *        2.quick sort
 *        3.the scope after the recursive
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return help(nums,nums.length-k+1,0,nums.length-1);
    }
    private int help(int[] nums,int k,int s,int e){

        if(s==e){//error

            return nums[s];
        }
        int i=p(nums,s,e);
        System.out.println("i"+i);
        if(k==i-s+1)return nums[i];
        else if(k<i-s+1)return help(nums,k,s,i-1);
        else return help(nums,k-i+s-1,i+1,e);//error the value of the k;
    }
    private int p(int[]nums,int s,int e){
        int p1=s;
        int p2=e+1;
        int v=nums[s];
        while(true){
            while(nums[++p1]<v){
                if(p1==e)break;
            };
            while(nums[--p2]>v){
                if(p2==s)break;
            };
            if(p1>=p2)break;
            else{
                int temp=nums[p1];
                nums[p1]=nums[p2];
                nums[p2]=temp;
            }
        }
        nums[s]=nums[p2];
        nums[p2]=v;
        return p2;
    }
    public static void main(String[] args) {
        int[] nums= new int[]{7,6,5,4,3,2,1};
        for (int num : nums) {
            System.out.println(num);
        }
        KthLargestElement test = new KthLargestElement();
        test.findKthLargest(nums, 5);
        System.out.println(test.findKthLargest(nums, 5));

    }
}
