package com.logact.array;

/**
 * @author: logact
 * @date: Created in 2019/8/26 15:02
 * @description:
 * easy
 * error:not initialize the value when the original state
 * method：use the character of the majority element(if the no.i number doesn't equals the candidate,order the result to be  subtracted by one else
 * add one ,if the count equals to the zero then order the candidate res to be the numbers[i])
 */
public class MajorityElement_169 {
    class Solution {
        public int majorityElement(int[] nums) {
            int count=0;
            int res=0;
            for(int i=0;i<nums.length;i++){
                if(count==0){
                    res=nums[i];
                    count++;
                }else{
                    if(res!=nums[i]){
                        count--;
                    }else{
                        count++;
                    }
                }
            }
            return res;
        }
    }
}
