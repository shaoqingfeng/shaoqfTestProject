package com.Executor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName: SpinLockDemo
 * @Description: TODO
 * @Author: shaoqf
 * @Date: 2021/1/31 20:52
 * 自旋锁(spinlock>
 * 是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，这样的好处是减少线程上下文切换的消耗，
 * 缺点是循环会消耗CPU
 * @Version: 1.0
 */

public class SpinLockDemo {

    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void mylock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t comein OOOOOO");
        while (!atomicReference.compareAndSet(null,thread)){
            System.out.println(Thread.currentThread().getName()+"\t heihiehieieh");
        }
    }
    public void myUnlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t invoked myUnlock end");

    }
    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
           spinLockDemo.mylock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            spinLockDemo.myUnlock();

        },"AAA").start();



        new Thread(()->{
            spinLockDemo.mylock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            spinLockDemo.myUnlock();

        },"bbbb").start();
    }
}
