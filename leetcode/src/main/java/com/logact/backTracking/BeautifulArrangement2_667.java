package com.logact.backTracking;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: logact
 * @date: Created in 2019/9/3 17:34
 * @description:
 */
public class BeautifulArrangement2_667 {
    /**
     * 使用回溯算法计算
     * 这是只要找到一个指定的答案在找到一个就可以推出。
     * 这需要：
     * 1. 通知其它正在等候进行（还没开始的递归函数）
     * 2.通知已经在执行的递归函数（需要对它进行额外的通知不然就会造成使得得到的解果在残余的步骤被改变
     * 如本题中的数组）
     */
    private boolean success=false;
    public int[] constructArray(int n, int k) {
        int[] res=new int[n];
        boolean[] check=new boolean[n];
        Set<Integer> set=new HashSet<Integer>();
        help(res,check,0,n,set,k);
        return res;
    }
    public void help(int[] res, boolean[] check, int index, int n, Set<Integer> set, int k){
        if(success){
            System.out.println("success");
            return;
        }
        if(index==n){
            if(set.size()!=k)return;
            success=true;
            return;
        }
        for(int i=0;i<n;i++){
            if(!check[i]){
                if(i==2)System.out.println(index);
                if(index!=0){//index==0时不检验
                    int v=i+1-res[index-1];
                    if(!set.contains(v)){
                        if(set.size()==k){
                            continue;
                        }else{
                            set.add(v);
                            res[index]=i+1;
                            check[i]=true;
                            help(res,check,index+1,n,set,k);
                            if(success)return;//如果成功终止下面的操作继续下去。
                            check[i]=false;
                            set.remove(v);
                        }
                    }else{
                        res[index]=i+1;
                        check[i]=true;
                        help(res,check,index+1,n,set,k);
                        if(success)return;//如果成功终止下面的操作继续进行
                        check[i]=false;
                    }
                }else{
                    res[index]=i+1;
                    check[i]=true;
                    help(res,check,index+1,n,set,k);
                    if(success)return;//如果成功终止下面的步骤继续进行
                    check[i]=false;
                }
            }
        }
    }

    /**
     * 使用双指针
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray1(int n, int k) {
        int[] arr = new int[n];
        int s = 1, e = n, i = 0;
        while(s <= e) {
            if((i < k && i % 2 == 0) || (i >= k && (k - 1) % 2 == 0)) arr[i++] = s++;
            else arr[i++] = e--;
        }
        return arr;

    }

    /**
     * 找规律
     * 在第一个到第k个数下偶数下标置为（0，1，2，3，4），奇数下标置为（k,k-1,..);这样在前k个数组下就会得出绝对值（数列之间相减）递减的数列
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray2(int n,int k){
        int[] res = new int[n];
        int a=1;
        int b=k+1;
        for (int i = 0; i < k; i++) {
            if((i&1)==0){//偶数置为1,2,3...位运算的优先级比较低要加括号。
                res[i]=a++;
            }else{
                res[i]=k--;
            }
        }
        for(int i=k;i<res.length;i++){
            res[i]=i+1;
        }
        return res;
    }
    public static void main(String[] args) {
        BeautifulArrangement2_667 test = new BeautifulArrangement2_667();
        boolean error =test.success;//私有变量合法访问出错。
        test.constructArray(3, 2);
    }
}
