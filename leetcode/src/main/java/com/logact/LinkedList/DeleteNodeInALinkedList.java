package com.logact.LinkedList;

import com.logact.tool.ListNode;

/**
 * @author: logact
 * @date: Created in 2019/8/31 15:50
 * @description:
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if(node.next==null)return ;

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
