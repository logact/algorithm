package com.logact.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: logact
 * @date: Created in 2019/9/3 14:44
 * @description:
 * easy
 *这道题用来与全排列作比较。
 * 大小写字母的Ascii码值差32.
 */
public class LitterCasePermutation_784 {
    public List<String> letterCasePermutation(String S) {
        List<String> res=new ArrayList<String>();
        if(S==null||S.length()==0){
            return res;
        }
        char[] temp=new char[S.length()];
        helper(S,res,temp,0);
        return res;
    }
    private void helper(String s,List<String> res,char[]temp,int n){
        if(n==s.length()){
            String ss=new String(temp);
            res.add(ss);
            return;
        }

        char c=s.charAt(n);
        if(c-'0'>=0&&c-'0'<=9){
            temp[n]=c;
            helper(s,res,temp,n+1);
        }else if(c-'a'>=0&&c-'z'<=0){
            temp[n]=c;
            helper(s,res,temp,n+1);
            temp[n]=(char)(c-32);
            helper(s,res,temp,n+1);
        }else if(c-'A'>=0&&c-'Z'<=0){
            temp[n]=c;
            helper(s,res,temp,n+1);
            temp[n]=(char)(c+32);
            helper(s,res,temp,n+1);
        }

    }
}
