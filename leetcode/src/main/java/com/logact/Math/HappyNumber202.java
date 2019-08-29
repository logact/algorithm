package com.logact.Math;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: logact
 * @date: Created in 2019/8/29 15:43
 * @description:
 * 易错点：错误的情况未考虑清楚。
 * easy
 */
public class HappyNumber202 {
    /**
     * method 1
     * use the recursive
     * the slowest method
     */
    Set<Integer> set = new HashSet<Integer>();
    public boolean isHappy(int n){
        set.add(n);
        if(n==1)return true;
        int nextNum=0;
        while(n>0){
            nextNum+=(n%10)*(n%10);
            n/=10;
        }
        System.out.println(nextNum);
        if(set.contains(nextNum))return false;
        return isHappy(nextNum);
    }
    /**
     * 在这个过程中如果产生了数字四。就一定不是快乐数。
     */
    /**
     *快慢指针
     */
    public boolean isHappy2(int num) {
        int slow=num;
        int fast=num;
        while(slow!=1&&fast!=1){
            slow=goHead(slow);
            fast=goHead(fast);
            fast=goHead(fast);
        }
        return true;
    }
    private int goHead(int p){
        int res=0;
        while(p>0){
            res+=(p%10)*(p%10);
            p/=10;
        }
        return res;
    }



}
