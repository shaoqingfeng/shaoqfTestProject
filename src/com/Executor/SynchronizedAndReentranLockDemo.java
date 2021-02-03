package com.Executor;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: SynchronizedAndReentranLockDemo
 * @Description: TODO
 * @Author: shaoqf
 * @Date: 2021/2/3 6:21
 * @Version: 1.0
 */
class ShareResource{
    private int  number =1;//A 1;B 2;C 3
    private Lock lock = new ReentrantLock();
    private Condition condition1 =  lock.newCondition();
    private Condition condition2 =  lock.newCondition();
    private Condition condition3 =  lock.newCondition();


    //判断
    //
    public  void print1(){
        lock.lock();
        try {
//判断
            while (number !=1){
                condition1.await();;
            }
            for (int i = 1; i <=1 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number =2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }
    }

    public  void print2(){
        lock.lock();
        try {
//判断
            while (number !=2){
                condition2.await();;
            }
            for (int i = 1; i <=2 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number =3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }
    }


    public  void print3(){
        lock.lock();
        try {
//判断
            while (number !=3){
                condition3.await();;
            }
            for (int i = 1; i <=3 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number =1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }
    }
}
public class SynchronizedAndReentranLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            for (int i = 1; i <=2 ; i++) {
                shareResource.print1();
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 1; i <=2 ; i++) {
                shareResource.print2();
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 1; i <=2 ; i++) {
                shareResource.print3();
            }
        },"CC").start();
    }
}
