package com.logact.Math;

/**
 * @author: logact
 * @date: Created in 2019/8/26 21:28
 * @description:
 */
public class PowerOfFour {
    /**
     * use the loop
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        int mod = 0;
        while (num != 1) {
            mod = num % 4;
            if (mod != 0) return false;
            num = num / 4;
        }
        return true;
    }

    /**
     * use the recursion
     * @param num
     * @return
     */
    public boolean isPowerOfFour2(int num){
        if(num<=0)return false;
        if(num==1)return true;
        if(num%4==0)return false;
        return isPowerOfFour2(num/4);
    }

    /**
     * use the  bit mainpulation
     * @param num
     * @return
     */
    public boolean isPowerOfFour3(int num){
        if(((num&(num-1))!=0)) {//note the priority of the '==' is higher than the '&'.
            return false;
        }
        if((num&0x55555555)==num)return true;
        return false;

    }

}
