package com.xiechao.swordToOffers.test;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.concurrent.Semaphore;

/**
 * @ClassName Test2
 * @Author xiechao
 * @Date 2019/2/28
 * @Time 21:36
 * @Description TODO
 */
public class Test2 {
    @Test
    public void test(){
        Semaphore semaphore1 = new Semaphore(0);
        System.out.println(semaphore1.availablePermits());
        semaphore1.release();
        System.out.println(semaphore1.availablePermits());
        semaphore1.release();
        System.out.println(semaphore1.availablePermits());


    }
}
