package com.logact.structure;

import java.util.HashMap;

/**
 * @author: logact
 * @date: Created in 2019/8/18 19:11
 * @description:
 * use the LinkedHashMap
 */
class LRUCache {
    class DbLinkedNode{
        int val;
        int key;
        DbLinkedNode pre;
        DbLinkedNode next;

        public DbLinkedNode() {
        }
    }

    private int capacity=0;
    private int size=0;
    private HashMap<Integer,DbLinkedNode> cache;
    DbLinkedNode head;
    DbLinkedNode tail;
    public LRUCache(int capacity) {
        cache=new HashMap<Integer, DbLinkedNode>();
        this.capacity=capacity;
        head=new DbLinkedNode();
        tail=new DbLinkedNode();
        head.next=tail;
        tail.pre=head;
    }
    public int get(int key){
        if (cache.containsKey(key)) {
            DbLinkedNode node=cache.get(key);

            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    private void moveToHead(DbLinkedNode node) {
        node.next.pre = node;
        node.pre.next = node.next;
        node.next=head.next;
        head=node;
    }

    public void put(int key,int value){
        DbLinkedNode node = cache.get(key);
        if(node==null){
            if(size>=capacity){
                deleteTail();
                size--;
            }
            node=new DbLinkedNode();
            node.val=value;
            node.key=key;
            addToHead(node);
            cache.put(key, node);
            size++;
        }else{
            node.val=value;
        }

    }

    private void addToHead(DbLinkedNode node) {
        node.next=head;
        head=node;
    }

    private void deleteTail() {
        tail.pre.next=null;
        tail=tail.pre;
    }

    public static void main(String[] args) {
        LRUCache test = new LRUCache(2);
        test.put(1, 10);
        test.put(2, 20);
        test.put(3, 30);
        test.put(4, 40);


    }

}
