package com.logact.Math;

/**
 * @author: logact
 * @date: Created in 2019/8/29 14:12
 * @description:
 * easy
 * two methods
 */
public class AddDigits_258 {
    /**
     * recursive
     * @return
     */
    public int addDigits(int num) {
        if(num<10)return num;
        int nextNum=0;
        while(num>0){
            nextNum+=num%10;
            num/=10;
        }
        return addDigits(nextNum);
    }

    /**
     *达到O(1)时间复杂度.
     * 可以分析出来每次相加后缩放的都是9的倍数，最后的结果也必是mod9的余数，只是要注意结果为9的这种情况
     */
    public int addDigits1(int num) {
        if(num<9)return num;
        if(num%9==0)return 9;
        else return num%9;
    }


}
