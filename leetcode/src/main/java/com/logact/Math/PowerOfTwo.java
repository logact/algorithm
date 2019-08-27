package com.logact.Math;

/**
 * @author: logact
 * @date: Created in 2019/8/26 21:19
 * @description:
 */
public class PowerOfTwo {
    public boolean check(int n){
        if(n<=0)return false;
        return (n&(n-1))==0;
    }
}
