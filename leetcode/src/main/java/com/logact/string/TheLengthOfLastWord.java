package com.logact.string;

/**
 * @author: logact
 * @date: Created in 2019/9/1 14:48
 * @description:
 */
public class TheLengthOfLastWord {
    /**
     * 直接数用两个变量一个变量保留当前数的个数，一个变量保留数的前一个不为零的变量，
     * （防止字符串末尾都是空格的情况）
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if(s==null)return 0;
        int res=0;
        int candidateRes=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(res!=0)candidateRes=res;
                res=0;
            }
            else res+=1;
        }
        if(res==0)return candidateRes;
        return res;
    }

    /**
     * the better method
     * 时间复杂度： o（n)n=末尾空格长度+最后一个字符的长度。
     * 由最后的单词长度可以想到应该可以从后面开始数。
     * @param s
     * @return
     */
    public int lengthOfLastWord1(String s) {
        int end =s.length()-1;
        while(end>=0&&s.charAt(end)==' '){
            end--;
        }
        if(end<0)return 0;
        int start=end;
        while(start>=0&&s.charAt(start)!=' '){
            start--;
        }
        return end-start;
    }
}
