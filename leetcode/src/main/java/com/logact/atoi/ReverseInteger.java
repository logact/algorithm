package com.logact.atoi;

/**
 * @author: logact
 * @date: Created in 2019/8/26 21:04
 * @description:
 * medium
 * 7
 * note that think of the condition that the result if overflow !
 */
public class ReverseInteger {
    public int reverse(int p){
        long x=p;
        long ans=0;
        int maxint=0x7fffffff;
        int minint=0x80000000;
        System.out.println(maxint);
        System.out.println(minint);

        while(x!=0){
            ans=ans*10+x%10;
        }
        if(ans<Integer.MIN_VALUE||ans>Integer.MAX_VALUE){
            return 0;
        }
        return  (int)ans;
    }

    public static void main(String[] args) {
        ReverseInteger test = new ReverseInteger();
        test.reverse(23);

    }
}
