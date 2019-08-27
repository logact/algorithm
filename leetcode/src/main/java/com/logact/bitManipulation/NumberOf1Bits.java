package com.logact.bitManipulation;

/**
 * @author: logact
 * @date: Created in 2019/8/26 21:33
 * @description:
 * easy
 * input a unsigned integer return the number of '1' bits it has.
 * the key: oder n&=n-1 will delete the last 1 in the number n;
 */
public class NumberOf1Bits {
    public int hammingWeight(int n){
        int count =0;
        while(n!=0){
            count++;
            n&=n-1;
        }
        return count;

    }
    /**
     * method 2 move the bie the mask code
     */
    public int hammingWeight2(int n){
        int mask=0;
        int bits=0;
        for(int i=1;i<=32;i++){
            if((mask&n)!=0)bits++;
            mask=mask>>1;
        }
        return bits;
    }
}
