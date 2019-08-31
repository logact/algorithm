package com.logact.LinkedList;

import com.logact.tool.ListNode;

/**
 * @author: logact
 * @date: Created in 2019/8/31 14:41
 * @description:
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(0);
        res.next =head;
        ListNode pre= res;
        for(ListNode node=head;node!=null;){
            if(node.val==val){
                pre.next=node.next;
                node=pre.next;
            }else{
                pre=pre.next;
                node = node.next;
            }
        }
        return res.next;
    }
}
