package com.logact.array;

/**
 *
 */
public class SpiralMatrix_Il_59 {
    static class Solution {
        public int[][] generateMatrix(int n) {
            int tr=0;
            int tc=0;
            int br=n-1;
            int bc=n-1;
            int [][] res=new int[n][n];
            int v=1;
            while(v<=n*n){
                for(int i=tc;i<=bc;i++){
                    if(v>n*n)return res;
                    res[tr][i]=v++;
                }
                for(int i=tr+1;i<=br;i++){
                    if(v>n*n)return res;
                    res[i][bc]=v++;
                }
                for(int i=bc-1;i>=tc;i--){
                    if(v>n*n)return res;
                    res[br][i]=v++;
                }
                for(int i=br-1;i>tr;i--){
                    System.out.println("4:"+v);
                    if(v>n*n)return res;
                    res[i][tc]=v++;
                }
                tr++;
                tc++;
                br--;
                bc--;

            }

            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println("test");
        int[][]res=new Solution().generateMatrix(4);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j <res[0].length ; j++) {
                System.out.println(res[i][j]);
            }

        }
    }
}
