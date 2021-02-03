package com.Executor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: CyclicBarrierDemo
 * @Description: TODO
 * @Author: shaoqf
 * @Date: 2021/2/1 9:18
 * @Version: 1.0
 */

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{ System.out.println("start……");});
        for (int i = 1; i <=7 ; i++) {
            final int tempi = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t shoujidi "+tempi+" 个qq");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } finally {
                }
            },String.valueOf(i)).start();
        }
    }
}
