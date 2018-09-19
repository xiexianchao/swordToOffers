package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * @author: xiehcao
 * @Date : 2018/9/19
 * @Time : 17:14
 * @description :复杂链表的赋值
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Problem35 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    //暴力法 O(n^2)  O(1)
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return null;
        RandomListNode copyHead = null;
        RandomListNode cur = pHead;
        RandomListNode copyCur = null;
        while(cur != null){
            RandomListNode temp = new RandomListNode(cur.label);
            if(copyCur == null){
                copyHead = temp;
                copyCur = temp;
            }else{
                copyCur.next = temp;
            }
            cur = cur.next;
            copyCur = temp;
        }
        cur = pHead;
        copyCur = copyHead;
        while( cur != null){
            if(cur.random != null){
              //找出random在复制链表中的位置
                RandomListNode cur2 = pHead;
                RandomListNode copyCur2 = copyHead;
                while( cur2 != cur.random){
                    cur2 = cur2.next;
                    copyCur2 = copyCur2.next;
                }
                copyCur.random = copyCur2;
            }
            cur = cur.next;
            copyCur = copyCur.next;
        }
        return copyHead;
    }

    //使用map O(n) O(n)
    public RandomListNode Clone2(RandomListNode pHead){
        if(pHead == null) return null;
        RandomListNode cur = pHead;
        RandomListNode copyHead = null;
        RandomListNode curCopy = null;
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        while( cur != null){
            RandomListNode temp = new RandomListNode(cur.label);
            if(curCopy == null){
                copyHead = temp;
                curCopy = temp;
            }else{
                curCopy.next = temp;
            }
            //map.put(cur,curCopy.next);
            cur = cur.next;
            curCopy = temp;
        }
        cur = pHead;
        curCopy = copyHead;
        while(cur != null){
            map.put(cur,curCopy);
            curCopy = curCopy.next;
            cur = cur.next;
        }
        cur = pHead;
        curCopy = copyHead;
        while( cur != null){
            if( cur.random != null){
                curCopy.random = map.get(cur.random);
            }
            cur = cur.next;
            curCopy = curCopy.next;
        }
        return copyHead;
    }

    //O(n) O(1)
    public RandomListNode Clone3(RandomListNode pHead){
        if(pHead == null) return null;
        RandomListNode cur = pHead;

        while(cur != null){
            RandomListNode copy = new RandomListNode(cur.label);
            RandomListNode next = cur.next;
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        cur = pHead;
        while( cur != null ){
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        //int count = 1;
        cur = pHead;
        RandomListNode curCopy = pHead.next;
        RandomListNode headCopy = pHead.next;
        while(  curCopy.next != null){
            RandomListNode next = cur.next.next;
            RandomListNode nextCopy = curCopy.next.next;
            cur.next = next;
            curCopy.next = nextCopy;

            cur = next;
            curCopy = nextCopy;
        }
        cur.next = null;
        return headCopy;

    }



    @Test
    public void test(){
        RandomListNode node_1 = new RandomListNode(1);
        RandomListNode node_2 = new RandomListNode(2);
        RandomListNode node_3 = new RandomListNode(3);
        RandomListNode node_4 = new RandomListNode(4);
        RandomListNode node_5 = new RandomListNode(5);
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        node_1.random = node_4;
        node_4.random = node_2;
        node_5.random = node_1;
        Clone3(node_1);
    }
}
