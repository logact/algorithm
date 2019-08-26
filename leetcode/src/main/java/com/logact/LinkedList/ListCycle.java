package com.logact.LinkedList;

import com.logact.tool.ListNode;

/**
 * @author: logact
 * @date: Created in 2019/8/18 18:03
 * @description:
 * easy
 * use two p slow and fast;
 */
public class ListCycle {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow=head;
            if(slow==null)return false;
            ListNode fast=head.next;
            if(fast==null)return false;
            while(fast!=slow){
                if(fast==null||fast.next==null)return false;
                fast=fast.next.next;
                slow=slow.next;
            }
            return true;

        }
    }
}
