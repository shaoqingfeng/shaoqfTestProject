package com.Executor;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: CountDownLatchDemo
 * @Description: TODO
 * @Author: shaoqf
 * @Date: 2021/2/1 6:54
 * @Version: 1.0
 */

public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i <=6 ; i++) {

            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 离开岗位");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"\t boss离开岗位");


    }
}
