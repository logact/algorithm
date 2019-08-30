package com.logact.LinkedList;

import com.logact.tool.ListNode;

/**
 * @author: logact
 * @date: Created in 2019/8/30 17:31
 * @description:
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null)return null;
        ListNode res=new ListNode(Integer.MIN_VALUE);
        res.next=head;
        ListNode cur=head;
        ListNode p=res;
        ListNode preCur=res;
        ListNode preP=null;
        while(cur!=null){
            while(p!=cur&&p.val<=cur.val){
                preP=p;
                p=p.next;

            }
            if(p==cur){
                preCur=cur;
                cur=cur.next;
                p=res;
                preP=null;
            }else{
                ListNode next=cur.next;
                if(preCur!=null){
                    preCur.next=cur.next;
                }
                cur=preCur;
                preP.next=cur;
                cur.next=p;
                preP=null;
                p=res;
            }

        }
        return res.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(3);
        head2.next=head3;
        head1.next=head2;
        head.next=head1;
        InsertionSortList test = new InsertionSortList();
        ListNode res= test.insertionSortList(head);
        for(ListNode n=res;n!=null;n=n.next){
            System.out.println(n.val);
        }

    }
}
