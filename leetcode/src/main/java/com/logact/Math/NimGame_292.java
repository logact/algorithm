package com.logact.Math;

/**
 * @author: logact
 * @date: Created in 2019/8/29 14:48
 * @description:
 */
public class NimGame_292 {
    /**
     * the key of this method is that we can't be left 4 stones to solve the problem.
     * the last heap of the stone's number is 4 which can make you fail.
     * @param n
     * @return
     */
    public boolean canWin(int n){
        return (n&3)!=0;
    }
    /**
     * dp and recursive
     * in  the condition that the number of the stones is n,if  we can win ,we need to let  the opponent pick the last stone in the condition
     * that number of the stones is n-1 or n-2 or n-3 (because the number of we can pick each time is 1,2,or 3) that mean the formula is that
     * f(n)=f(n-1)||f(n-2)||f(n-3)
     * we can use the recursivilty to descirbe the formula directly but when the n is little big it will cause the problem of overflow  stack just
     * like the problem fibonacci
     * it's about some reverse thinking.
     */
    public boolean canWin2(int  n){
        if(n<=3)return true;
        else return (canWin2(n - 1)) || (canWin2(2)) || (canWin2(n - 3));

    }
}
