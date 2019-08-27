package com.logact.Math;

/**
 * @author: logact
 * @date: Created in 2019/8/26 21:27
 * @description:
 */
public class PowerOfThree {
    /**
     * use the loop
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if(n<=0)return false;
        while(n!=1){
            if(n%3!=0)return false;
            n=n/3;
        }
        return true;

    }

    /**
     * use the character of the pow of 3: that it only contains the prime factor
     *beats the 5.07 %users the slowest method
     * @param n
     * @return
     */
    public boolean isPowerOfThree1(int n){
        int max_int=0x7fffffff;
        int k = (int) (Math.log(max_int)/Math.log(3));//because that the java doesn't have the function like that log(a,b) so use the logab;

        int MAX_POWER_OF_THREE = (int) Math.pow(3,k);
        return (MAX_POWER_OF_THREE%n==0);


    }
}
