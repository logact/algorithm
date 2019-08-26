package com.logact.LinkedList;

import com.logact.tool.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: logact
 * @date: Created in 2019/8/18 18:19
 * @description:
 * 142
 * medium
 *  * 2 methods:
 * a.HashSet
 * b.slow and fast pointer(?)
 */
public class LinkedListCycleII {
    /**
     * use the hashset
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        for (ListNode node = head; node != null; node = node.next) {
            if (set.contains(node)) {
                return node;
            } else {
                set.add(node);
            }
        }
        return null;

    }
    /**
     * use the slow and quick pointer
     */
    public static void main(String[] args) {
        HashMap<Integer, String > test = new HashMap<Integer, String>();
        test.put(1, "a");
        test.put(2, "b");
        test.put(3, "c");
        test.put(4, "d");
        test.put(5, "e");
        test.put(6, "f");
        test.put(7, "g");
        test.put(8, "h");
        test.put(9, "i");
        test.remove(2);
        test.remove(4);
        test.remove(6);
        test.remove(5);
        test.remove(9);
        test.remove(8);
        System.out.println("test done");
    }
}