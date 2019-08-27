package com.logact.Math;

/**
 * @author: logact
 * @date: Created in 2019/8/27 16:23
 * @description:
 */
public class FactorialTrailingZeros {
    /**
     * get the answer directly
     * error:
     * when the n is a bit big the value of the factorial is out of the value of the max_int which wil cause the overflow
     */
    public int trailingZeroes(int n) {
        int factorial=1;
        int n1=n;
        while(n1>1){
            factorial*=n1;
            n1=n1-1;
        }
        System.out.println(factorial);

        int count=0;
        while(factorial!=0){
            if(factorial%10==0){
                count++;
                factorial=factorial/10;
            }
            else{
                return count;
            }
        }
        return count;
    }
    /**
     * the right solution
     * the key :find the amount of the 5 in the factors of the number 'n';
     */
    public int trailingZeroes1(int n){
        return n>=5?n/5+trailingZeroes(n/5):0;
    }

}
