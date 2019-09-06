package com.logact.slidingWindows;

import java.util.ArrayDeque;

/**
 * @author: logact
 * @date: Created in 2019/9/6 16:36
 * @description:
 */
public class SlidingWindowsMaximum {
    class ListNode {
        int index;
        int val;
        ListNode pre;
        ListNode next;

        public ListNode(int v, int index) {
            this.val = v;
            this.index = index;
            this.pre = null;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        SlidingWindowsMaximum test = new SlidingWindowsMaximum();
        int[]array={5,3,4};
        test.maxSlidingWindow(array, 1);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[0];
        if (nums.length == 0) return res;
        res = new int[nums.length - k + 1];
        ListNode head = new ListNode(0, 0);
        ListNode p = head;
        for (int i = 0; i < k && i < nums.length; i++) {//处理前k个情况
            if (head.next == null) {
                ListNode node = new ListNode(nums[i], i);
                node.pre = p;
                p.next = node;
                p = node;
            } else {
                if (p.val > nums[i]) {
                    ListNode node = new ListNode(nums[i], i);
                    node.pre = p;
                    p.next = node;
                    p = node;
                } else {
                    while (p != head && p.val < nums[i]) {
                        p.pre.next = null;
                        p = p.pre;
                    }
                    ListNode node = new ListNode(nums[i], i);
                    p.next = node;
                    node.pre = p;
                    p = node;
                }
            }
        }
        res[0] = head.next.val;

        //处理后面的情况
        for (int i = k; i < nums.length; i++) {
            if (head.next == null) {
                ListNode node = new ListNode(nums[i], i);
                node.pre = p;
                p.next = node;
                p = node;
            } else {
                if (p.val > nums[i]) {
                    ListNode node = new ListNode(nums[i], i);
                    node.pre = p;
                    p.next = node;
                    p = node;
                } else {
                    while (p != head && p.val < nums[i]) {
                        p.pre.next = null;
                        p = p.pre;
                    }
                    ListNode node = new ListNode(nums[i], i);
                    p.next = node;
                    node.pre = p;
                    p = node;
                }
            }
            if (i - head.next.index <= k - 1) {
                res[i - k + 1] = head.next.val;
            } else {
                head.next.next.pre=head;//在双向链表中删除一个节点时要注意pre指针的变化。
                head.next = head.next.next;
                res[i - k + 1] = head.next.val;
            }

        }
        return res;
    }
    /**
     * 使用ArrayDeque
     *
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(k*nums.length==0)return new int[0];
        int[] res=new int[nums.length-k+1];
        //初始化前k个
        ArrayDeque<Integer> dq=new ArrayDeque<Integer>();
        for(int i=0;i<k;i++){
            slidWindow(nums, dq, i,k);
        }
        res[0]=nums[dq.getFirst()];

        for (int i = k; i < nums.length; i++) {
            slidWindow(nums, dq, i, k);
            res[i-k+1]=nums[dq.getFirst()];
        }
      return res;
    }
    private void slidWindow(int[] nums,ArrayDeque<Integer> dq,int i,int k){

        if(!dq.isEmpty()&&i-dq.getFirst()==k){
            dq.removeFirst();//这一句其实很重要，要插入队列的时候检查队首指针是否已经失效。不可能存入两个失效的值
        }
        while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) {
            dq.removeLast();
        }
        dq.addLast(i);
    }
}
