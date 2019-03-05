package com.xiechao.swordToOffers.algorithms.linklist;

/**
 * @ClassName LeetCode138
 * @Author xiechao
 * @Date 2019/3/5
 * @Time 10:01
 * @Description LeetCode138. Copy List with Random Pointer
 * 复杂链表的复制
 *
 *
 */
public class LeetCode138 {
    private class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        while(cur != null){
            Node next = cur.next;
            Node copy = new Node();
            copy.val = cur.val;
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        cur = head;
        while(cur != null){
            if(cur.random != null){
                Node random = cur.random;
                cur.next.random = random.next;
            }
            cur = cur.next.next;
        }
        Node copyHead = head.next;
        Node odd = head;
        cur = head.next;
        while( cur.next != null){
            odd.next = odd.next.next;
            cur.next = cur.next.next;
            odd = odd.next;
            cur = cur.next;
        }
        odd.next = null;
        return copyHead;
    }
}
