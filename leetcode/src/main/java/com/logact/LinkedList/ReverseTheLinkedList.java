package com.logact.LinkedList;

import com.logact.tool.ListNode;

/**
 * @author: logact
 * @date: Created in 2019/8/26 15:13
 * @description:
 * easy
 * methods: two method(iteratively,recursively)
 * iteratively:
 * recursively:
 *
 */
public class ReverseTheLinkedList {
    class Solution {
        /**
         *iteratively
         */
        public ListNode reverseList(ListNode head) {
            ListNode cur=head;
            ListNode pre=null;
            ListNode next=null;
            while(cur!=null){
                next=cur.next;
                cur.next=pre;
                pre=cur;
                cur=next;
            }
            return pre;
        }

        /**
         * recursively
         * @param head
         * @return
         */
        public ListNode reverseList2(ListNode head){
            if(head==null||head.next==null)return head;
            ListNode res=reverseList2(head.next);
            head.next.next=head;
            head.next=null;
            return null;
        }
    }

}
