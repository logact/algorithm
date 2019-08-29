package com.logact.Math;

/**
 * @author: logact
 * @date: Created in 2019/8/29 16:48
 * @description:
 */
public class MyPow_50 {
    /**
     * method 1:recursive
     */
    public double pow(int n,double x){
        if(n>0)return help(n,x);
        return 1/help(-n,x);
    }
    private double help(int n,double x){
        if(n==0)return 1.0;
        if(n==1)return x;
        double half=help(n/2,x);
        if((n&1)==0){
            return half*half;
        }else{
            return half*half*x;
        }
    }
}
