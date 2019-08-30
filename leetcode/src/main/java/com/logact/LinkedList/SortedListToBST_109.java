package com.logact.LinkedList;

import com.logact.tool.ListNode;
import com.logact.tool.TreeNode;
import com.logact.tree.ArrayToBST_108;

/**
 * @author: logact
 * @date: Created in 2019/8/30 14:17
 * @description:
 * medium
 *
 */
public class SortedListToBST_109 {

    /**
     * 用快慢指针找出链表的中间值；
     * 由于leetcode的一些关于树表示的问题所以造成了在解析答案的时候会有一些错误，但是还是通过了。
     * 这个方法的时间复杂度？
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)return null;
        ListNode mid = getMid(head);
        System.out.println(mid.val);
        TreeNode root = new TreeNode(mid.val);
        if(mid==head)return root;
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(mid.next);
        return root;
    }
    private  ListNode getMid(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        ListNode preSlow=head;
        while(fast!=null&&fast.next!=null){
            preSlow=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(preSlow!=null){
            preSlow.next=null;
        }

        return slow;
    }

    /**
     * 用数组将链表的值给存起来。
     * 空间换时间
     * 节省了数组找出中点的时间
     * 时间复杂度？
     * 空间复杂度？
     * @param head
     * @return
     */
    public TreeNode sortedListToBST2(ListNode head){
        if(head==null)return null;
        int count =0;
        for (; head != null; head = head.next) {
            count++;
        }
        int [] helper=new int[count];
        return new ArrayToBST_108().sortedArrayToBST(helper);
    }

    /**
     * 终极方法利用树的遍历方式 中序遍历
     * 中序遍历模拟。改天再做；
     * @param head
     * @return
     */
    public TreeNode sortedListToBST3(ListNode head){

        return null;
    }
}
