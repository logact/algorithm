package com.logact.LinkedList;

import com.logact.tool.ListNode;

/**
 * @author: logact
 * @date: Created in 2019/8/31 16:55
 * @description:
 * easy
 * 三种方法：
 * 1.逆转链表后相加
 * 2.用栈将在不改变链表的顺序下逆转
 * 前面两种方法的基本目的都是为了要得到链表的逆转顺序。
 * 3.用递归。
 */
public class AddTwoNumbers2 {
    /**
     * 这种方法改变了链表的结构
     * 逆转链表相加。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverse(l1);
        l2=reverse(l2);


        ListNode res=new ListNode(0);
        ListNode p=res;
        int pop=0;
        while(l1!=null&&l2!=null){
            int v=l1.val+l2.val+pop;
            ListNode node =new ListNode(v%10);
            p.next=node;
            p=p.next;
            if(v>=10)pop=1;
            else pop=0;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1!=null){
            while(l1!=null){
                if(pop==1){
                    int v=l1.val+pop;
                    ListNode node=new ListNode(v%10);
                    p.next=node;
                    p=p.next;
                    if(v>=10)pop=1;
                    else pop=0;

                    l1=l1.next;
                }else{
                    p.next=l1;
                    break;
                }
            }
        }else if(l2!=null){
            while(l2!=null){
                if(pop==1){
                    int v=l2.val+pop;
                    ListNode node=new ListNode(v%10);
                    p.next=node;
                    p=p.next;
                    if(v>=10)pop=1;
                    else pop=0;
                    l2=l2.next;
                }else{
                    p.next=l2;
                    break;
                }
            }
        }
        if(pop==1){
            p.next=new ListNode(1);
        }
        return reverse(res.next);
    }
    private ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
