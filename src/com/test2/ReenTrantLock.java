package com.test2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ReenTrantLock
 * @Description: TODO
 * @Author: shaoqf
 * @Date: 2020/6/6 15:02
 * @Version: 1.0
 */

public class ReenTrantLock {
    private static int count=0;
    //重入锁
    private static Lock lock = new ReentrantLock();

    public  static  void inc(){

        lock.lock();//获得锁（互斥锁）

        try {
            Thread.sleep(1);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();//释放锁
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i <1000 ; i++) {
            new Thread(()->ReenTrantLock.inc()).start();
        }
        Thread.sleep(1850);
        System.out.println("result = [" + count + "]");
    }
}
