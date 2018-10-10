package com.xiechao.swordToOffers.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: xiehcao
 * @Date : 2018/9/28
 * @Time : 16:06
 * @description :
 */
public class LeetCode341 {
    public interface NestedInteger {
     public boolean isInteger();
     public Integer getInteger();
     public List<NestedInteger> getList();
  }

    public class NestedIterator implements Iterator<Integer> {
        Queue<Integer> queue = new LinkedList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            addListToQueue(nestedList);
        }

        private void addListToQueue(List<NestedInteger> nestedList) {
            for (NestedInteger e : nestedList) {
                if (e.isInteger()) {
                    queue.add(e.getInteger());
                } else {
                    addListToQueue(e.getList());
                }
            }
        }



        @Override
        public Integer next() {
            return queue.remove();
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
