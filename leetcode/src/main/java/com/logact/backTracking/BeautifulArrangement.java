package com.logact.backTracking;

/**
 * @author: logact
 * @date: Created in 2019/9/3 14:52
 * @description:
 */
public class BeautifulArrangement {
    /**
     * 使用回溯算法。
     */
    private int res=0;
    public int countArrangement(int N) {
        boolean[] check=new boolean[N];
        help(1,check,N,"");
        return res;
    }
    public void help(int n,boolean[] check,int N,String test){
        if(n==N+1){
            res++;
            System.out.println(test);
            return;
        }
        /**
         对长度为n的数组进行遍历查看第i位能否填入特定的值，如果能够填入则行前前进，达到低后就返回。
         */
        for(int i=0;i<N;i++){
            if(!check[i]){
                if(n%(i+1)==0||(i+1)%n==0){
                    check[i]=true;
                    help(n+1,check,N,test+","+(i+1));
                    check[i]=false;
                }
            }
        }
    }
}
