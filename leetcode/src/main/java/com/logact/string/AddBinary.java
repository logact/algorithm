package com.logact.string;

/**
 * @author: logact
 * @date: Created in 2019/9/2 18:44
 * @description:
 */
public class AddBinary {
    /**
     * 使用数组操作代替StringBuffer这样快的多
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        int len = a.length() + 1;
        char[] newCharArray = new char[len];
        int flag = 0;
        int num = 0;
        int gap = a.length() - b.length();
        for (int i = a.length() - 1; i >= gap; i--) {
            num = flag + a.charAt(i) + b.charAt(i - gap) - '0' * 2;
            newCharArray[--len] = num % 2 == 0 ? '0' : '1';
            flag = num / 2;
        }
        for (int i = gap - 1; i >= 0; i--) {
            num = flag + a.charAt(i) - '0';
            newCharArray[--len] = num % 2 == 0 ? '0' : '1';
            flag = num / 2;
        }
        if (flag == 1) {
            newCharArray[0] = '1';
        }
        if (newCharArray[0] == '1') {
            return new String(newCharArray);
        }
        return new String(newCharArray, 1, a.length());

    }

    /**
     * 使用stringBuffer
     * @param a
     * @param b
     * @return
     */
    public String addBinary1(String a,String b){
        int pop=0;
        StringBuffer sb=new StringBuffer();
        int pa=a.length()-1;
        int pb=b.length()-1;
        while(pa>=0||pb>=0){
            int temp=0;
            if(pa<0){
                temp=b.charAt(pb)-'0'+pop;
                pb--;
            }else if(pb<0){
                temp=a.charAt(pa)-'0'+pop;
                pa--;
            }else{
                temp=a.charAt(pa)-'0'+b.charAt(pb)-'0'+pop;
                System.out.println("temp"+temp);
                pa--;
                pb--;
            }
            if(temp==0){
                pop=0;
                sb.insert(0,0);
            }else if(temp==1){
                pop=0;
                sb.insert(0,1);

            }else if(temp==2){
                pop=1;
                sb.insert(0,0);

            }else if(temp==3){
                pop=1;
                sb.insert(0,1);
            }
        }
        if(pop==1)sb.insert(0,1);
        return sb.toString();
    }
}
