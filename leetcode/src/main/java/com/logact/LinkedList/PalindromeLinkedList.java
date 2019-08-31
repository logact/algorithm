package com.logact.LinkedList;

import com.logact.tool.ListNode;

/**
 * @author: logact
 * @date: Created in 2019/8/31 15:08
 * @description:
 * easy
 */
public class PalindromeLinkedList {
    /**
     * 直接将链表转为数组的的方法
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head==null)return true;
        int count=0;
        ListNode node =head;
        while(node!=null){
            count++;
            node=node.next;
        }

        int [] helper=new int[count];
        for(int i=0;i<count;i++){
            helper[i]=head.val;
            head=head.next;
        }
        int p1=0;
        int p2=count-1;
        while(p1<p2){
            if(helper[p1]==helper[p2]){
                p1++;
                p2--;
            }else{
                return false;
            }

        }
        return true;
    }

    /**
     * 逆转链表加快慢指针法
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        if(head==null)return true;
        //翻转链表的方法
        ListNode fast=head;
        ListNode slow=head;
        ListNode pre=null;
        while(fast!=null&&fast.next!=null){
            pre=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        if(pre!=null)pre.next=null;
        if(fast!=null){
            slow=slow.next;
        }
        if(slow==null)return true;
        ListNode pre1=null;
        ListNode cur=head;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=pre1;
            pre1=cur;
            cur=next;
        }

        while(slow!=null&&pre1!=null&&pre1.val==slow.val){
            pre1=pre1.next;
            slow=slow.next;
        }
        if(pre1!=null)return false;
        return true;
    }
}
