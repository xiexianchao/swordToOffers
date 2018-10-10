package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * @author: xiehcao
 * @Date : 2018/9/29
 * @Time : 11:13
 * @description :
 */
public class LeetCode380 {
    class RandomizedSet {

        //71 ms
        private Set<Integer> set = null;
        private Random random = new Random();
        /** Initialize your data structure here. */
        public RandomizedSet() {
            this.set = new HashSet<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            return set.add(val);
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            return set.remove(val);
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int count = random.nextInt(set.size())+1;
            int result = 0;
            Iterator<Integer> iterator = set.iterator();
            while(iterator.hasNext()){
               count -- ;
               result = iterator.next();
               if(count == 0)
                   break;
            }
            return result;
        }

    }


    @Test
    public void test(){
// Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomSet.insert(1));

// Returns false as 2 does not exist in the set.
        System.out.println(randomSet.remove(2));

// Inserts 2 to the set, returns true. Set now contains [1,2].
       System.out.println(randomSet.insert(2));

// getRandom should return either 1 or 2 randomly.
       System.out.println( randomSet.getRandom());

// Removes 1 from the set, returns true. Set now contains [2].
     System.out.println(randomSet.remove(1));

// 2 was already in the set, so return false.
      System.out.println( randomSet.insert(2));

// Since 2 is the only number in the set, getRandom always return 2.
       System.out.println( randomSet.getRandom());
    }
}
