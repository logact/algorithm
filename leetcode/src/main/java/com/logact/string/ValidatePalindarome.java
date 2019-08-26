package com.logact.string;

/**
 * @author: logact
 * @date: Created in 2019/8/17 17:26
 * @description:
 */
public class ValidatePalindarome {
    public boolean isPalindrome(String s) {
        int p1=0;
        int p2=s.length()-1;
        while(p1<p2){
            if(!check(s.charAt(p1))){
                p1++;
                continue;
            }
            if(!check(s.charAt(p2))){
                p2--;
                continue;
            }
            if(equal(s.charAt(p1),s.charAt(p2))){
                p1++;
                p2--;
            }else{
                System.out.println(s.charAt(p1));
                System.out.println(s.charAt(p2));
                return false;
            }

        }
        return true;

    }
    public boolean check(char c){
        if(c>=97&&c<=122)return true;
        if(c>=65&&c<=90)return true;
        if(c>=48&&c<=57)return true;
        return false;
    }
    public boolean equal(char c1,char c2){
        if(c1==c2)return true;
        if(c1>=48&&c1<=57)return false;
        if(c2>=48&&c2<=57)return false;
        if(c1==(char)(c2+32))return true;
        if((char)(c1+32)==c2)return true;
        else return false;
    }

    public static void main(String[] args) {
        ValidatePalindarome test = new ValidatePalindarome();
        System.out.println(test.isPalindrome("0P"));
    }



}
