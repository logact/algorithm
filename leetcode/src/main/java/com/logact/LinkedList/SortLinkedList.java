package com.logact.LinkedList;

import com.logact.tool.ListNode;

/**
 * @author: logact
 * @date: Created in 2019/8/20 14:20
 * @description:
 * 148
 * medium
 */
public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        ListNode head1=sortList(head);
        ListNode head2=sortList(temp);
        ListNode res = new ListNode(0);
        ListNode h=res;
        while(head1!=null||head2!=null){
            if(head1==null){
                h.next=head2;
                break;
            }
            if(head2==null){
                h.next=head1;
                break;
            }
            if(head1.val<head2.val){
                h.next=head1;
                h=head1;
                head1=head1.next;
            }else{
                h.next=head2;
                h=head2;
                head2=head2.next;
            }
        }
        return res.next;

    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(4);
        ListNode node2=new ListNode(6);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(3);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        SortLinkedList test = new SortLinkedList();
        ListNode res = test.sortList(head);
        for(ListNode node=res;node!=null;node=node.next){
            System.out.println(node.val);
        }


    }
}
