package com.logact.LinkedList;

import com.logact.tool.ListNode;

/**
 * @author: logact
 * @date: Created in 2019/8/31 16:12
 * @description:
 * medium
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd=new ListNode(0);
        ListNode p1=odd;
        ListNode even=new ListNode(0);
        ListNode p2=even;
        boolean flag=true;
        while(head!=null){
            if(flag){
                p1.next=head;
                p1=p1.next;
                flag=!flag;
            }else{
                p2.next=head;
                p2=p2.next;
                flag=!flag;
            }
            head=head.next;
        }
        if(p2.next!=null){
            p2.next=null;
        }
        p1.next=even.next;
        return odd.next;
    }
}
