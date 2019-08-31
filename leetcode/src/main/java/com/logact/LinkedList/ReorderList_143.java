package com.logact.LinkedList;

import com.logact.tool.ListNode;

/**
 * @author: logact
 * @date: Created in 2019/8/30 15:52
 * @description:
 */
public class ReorderList_143 {
    public void reorderList(ListNode head) {
        ListNode p1=head;
        ListNode p2=p1;
        ListNode p3=null;
        for(;p1!=null;){
            ListNode next=p1.next;
            while(p2.next!=null){
                p3=p2;//让探路指针延迟一步。保留探路指针前面的指针。
                p2=p2.next;
            }
            if(p2==p1)return;
            if(p2==next)return;//想清楚极端情况。
            if(p3!=null)p3.next=null;
            p2.next=next;
            p1.next=p2;
            p3=p1;
            p1=next;
            p2=p1;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        head2.next=head3;
        head1.next=head2;
        head.next=head1;
        ReorderList_143 test = new ReorderList_143();
        test.reorderList(head);

    }
}
