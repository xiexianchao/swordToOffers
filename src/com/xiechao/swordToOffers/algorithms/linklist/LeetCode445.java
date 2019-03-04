package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;
import com.xiechao.swordToOffers.leetcode.LeetCode44;
import org.junit.Test;
import sun.security.util.Length;

import java.util.List;
import java.util.Stack;

/**
 * @ClassName LeetCode445
 * @Author xiechao
 * @Date 2019/2/26
 * @Time 14:25
 * @Description TODO
 *
 * LeetCode445 Add Two Numbers II
 * 相加两个链表，左对齐
 *
 */
public class LeetCode445 {
    //我的方法，虽然不反转输入链表，但反转输出链表以求进位
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      if(l1 == null) return l2;
      if(l2 == null) return l1;
      int countNode1 = 0;
      int countNode2 = 0;
      ListNode cur1 = l1;
      while(cur1 != null){
          countNode1++;
          cur1 = cur1.next;
      }
      ListNode cur2 = l2;
      while(cur2 != null){
            countNode2++;
            cur2 = cur2.next;
      }
      cur1 = l1;
      cur2=l2;
      ListNode pre = new ListNode(0);
      ListNode fakeHead = pre;
      if(countNode1 > countNode2){
          while(countNode1 > countNode2){
              ListNode node = new ListNode(cur1.val);
              pre.next = node;
              pre = node;
              cur1 = cur1.next;
              countNode1--;
          }
      }else{
          while(countNode1 < countNode2){
              ListNode node = new ListNode(cur2.val);
              pre.next = node;
              pre = node;
              cur2 = cur2.next;
              countNode2--;
          }
      }
      while(cur1 != null && cur2 != null){
          ListNode node = new ListNode(cur1.val + cur2.val);
          pre.next = node;
          pre = node;
          cur1 = cur1.next;
          cur2 = cur2.next;
      }
      ListNode head = reverse(fakeHead.next);
      ListNode cur = head;
      int preCount = 0;
      while(cur != null){
          int temp = cur.val;
          cur.val = (temp + preCount)%10;
          preCount = (temp + preCount)/10;
          cur = cur.next;
      }
      head = reverse(head);
      ListNode realHead = head;
      if(preCount > 0){
          realHead = new ListNode(preCount);
          realHead.next = head;
      }
      return realHead;
    }

    ListNode reverse(ListNode node){
        if(node == null || node.next == null) return node;
        ListNode pre = null;
        ListNode cur = node;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //LeetCode方法，递归求和
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int countNode1 = 0;
        int countNode2 = 0;
        ListNode cur1 = l1;
        while (cur1 != null) {
            countNode1++;
            cur1 = cur1.next;
        }
        ListNode cur2 = l2;
        while (cur2 != null) {
            countNode2++;
            cur2 = cur2.next;
        }
        ListNode fakeHead = new ListNode(0);
        ListNode result = countNode1 > countNode2 ? helper(l1,countNode1,l2,countNode2) : helper(l2,countNode2,l1,countNode1);
        fakeHead.next = result;
        if(result.val > 9){
            fakeHead.val = result.val / 10;
            result.val %= 10;
            return fakeHead;
        }
        return fakeHead.next;
    }
    private ListNode helper(ListNode l1,int length1, ListNode l2, int length2){
        if(length1 == 0 || length2 == 0) return null;
        ListNode result = length1 == length2 ? new ListNode(l1.val + l2.val) : new ListNode(l1.val);
        ListNode post = length1 == length2 ? helper(l1.next, length1 - 1,l2.next,length2 - 1) : helper(l1.next,length1-1,l2,length2);
        if(post != null && post.val > 9){
            result.val += post.val / 10;
            post.val %= 10;
        }
        result.next = post;
        return result;
    }


  //用栈来做
  public ListNode addTwoNumbers3(ListNode l1, ListNode l2){
      if (l1 == null) return l2;
      if (l2 == null) return l1;
      Stack<Integer> stack1 = new Stack<>();
      Stack<Integer> stack2 = new Stack<>();
      ListNode cur = l1;
      while(cur != null){
          stack1.push(cur.val);
          cur = cur.next;
      }
       cur = l2;
      while(cur != null){
          stack2.push(cur.val);
          cur = cur.next;
      }
      ListNode pre = new ListNode(0);
      int sum = 0;
      while( !stack1.isEmpty() || ! stack2.isEmpty()){
          if( !stack1.isEmpty()) sum += stack1.pop();
          if( !stack2.isEmpty()) sum += stack2.pop();
          pre.val = sum % 10;
          ListNode temp  = new ListNode(sum / 10);
          temp.next = pre;
          pre = temp;
          sum /= 10;
      }
      return pre.val == 0 ? pre.next:pre;
    }
    @Test
    public void test(){
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);
        node5.next = node6;
        node6.next = node7;
        addTwoNumbers2(node1, node5);
    }

}
