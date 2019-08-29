package com.logact.Math;

/**
 * @author: logact
 * @date: Created in 2019/8/29 18:56
 * @description:
 * 计算某个数字的某位数字。（将其转换位字符串再转换为数字）
 */
public class NthDigit {
    /**
     * 暴力方法
     *
     * @return
     */
    public int findNthDigit(int n) {
        int i = 1;
        int c = 0;
        while (c < n) {
            c += getLength(i);
            i++;
        }
        i--;//注意这里i的意义要减一才是所要求得的值
        if (c == n) {
            String si = i + "";
            return si.charAt(si.length() - 1 - (c - n)) - '0';
        } else {
            String si = i + "";
            return si.charAt(si.length() - 1 - (c - n)) - '0';
        }
    }

    private int getLength(int i) {
        int count = 0;
        while (i != 0) {
            count++;
            i /= 10;
        }
        return count;
    }
    /**
     * 正解
     */
    public int findNthDigit1(int n) {
        //9个1位数90个2位数900个三位数9000个四位数
        int i = 1;
        long k = 9L;
        long sum = 9L;
        while(sum < n) {
            i += 1;
            k *= 10;
            sum += i * k;
        }
        //i为当前数字的位数
        long diff = (sum - n) / i;
        long d = (sum - n) % i;
        long curNum = (long)Math.pow(10, i) - 1 - diff;
        String curStr = String.valueOf(curNum);
        return curStr.charAt(curStr.length() - 1 - (int)d) - '0';
    }

}
