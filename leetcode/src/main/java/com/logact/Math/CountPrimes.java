package com.logact.Math;

/**
 * @author: logact
 * @date: Created in 2019/8/27 17:20
 * @description:
 */
public class CountPrimes {
    /**
     * violent solution
     * O(n)=n*n
     * error:
     * out of time limit
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int res = 0;
        n = n - 1;
        while (n >= 2) {
            if (isPrime(n)) res++;
            n--;
        }
        return res;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        int h = n / 2;
        while (h > 1) {
            if (n % h == 0) return false;
            h--;
        }
        return true;
    }

    /**
     * method 2 in this method we don't need to determinate a number is a prime or not;
     * error :think that we iterate the i from the 0 to the n-1 if the i is a composite number then before operating it, the loop which determinate the
     * multiple of the number must have find it is  composite because that it has the factor that appear before it.
     *
     * @param n
     * @return
     */
    public int countPrimes1(int n) {
        if (n <= 2) return 0;
        int res = 0;
        boolean isComposite[] = new boolean[n];
        int i = 2;
        while (i < n) {
            if (!isComposite[i]) {
                res++;
                for (int j = i + i; j < n; j = j + i) {
                    isComposite[j] = true;
                }
            }
            i++;
        }
        return res;
    }

    /**
     * use the bitmap
     * save the memory ,because we just need to story two sate of the numbers so we use the bit 1 or 0 to present.
     *
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        int count = 0;
        //一个 int 变量占用 32 字节
        //在C#中，提供了点阵列（BitArray）数组，用这玩意可读性一定会好于我写的代码。
        int[] signs = new int[n / 32 + 1];
        for (int i = 2; i < n; i++) {
            //将元素和需确定得数字经行按位或运算，如果值改变，说明不存在该数字（未登记该数字），则其为质数。
            //(当某个数为 2 的 n 次方时（n为自然数），其 & (n - 1) 所得值将等价于取余运算所得值)
            //*如果 x = 2^n ，则 x & (n - 1) == x % n
            //下面判断可以写成
            //if ((signs[i / size] & (1 << (i % 32))) == 0)
            if ((signs[i / 32] & (1 << (i & 31))) == 0) {
                count++;
                for (int j = i + i; j < n; j += i) {
                    //登记该数字
                    signs[j / 32] |= 1 << (j & 31);
                }
            }
        }
        return count;


    }
}
