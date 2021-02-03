package com.Executor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ReentrantLockDemo
 * @Description: TODO
 * @Author: shaoqf
 * @Date: 2021/1/31 10:10
 * @Version: 1.0
 */
class Phone{
    public synchronized void sendSms() throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t ######invoked sendEmail()");
    }
}

class Phone2 implements Runnable    {
    public synchronized void sendSms() throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t ######invoked sendEmail()");
    }
     Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }
    public void get(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t invoked get()");
            set();
        }finally {
            lock.unlock();

        }

     }
    public  void set(){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"\t ######invoked set()");
        lock.unlock();
    }
}
public class ReentrantLockDemo {

    public static void main(String[] args) {
            Phone phone = new Phone();
        Phone2 phone2 = new Phone2();

        new Thread(()->{
                try {
                    phone.sendSms();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"T1").start();

        new Thread(()->{
            try {
                phone.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"T2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        Thread thread3 = new Thread(phone2,"T3");
        Thread thread4 = new Thread(phone2,"T4");

        thread3.start();
        thread4.start();
//        new Thread(()->{
//            try {
//                phone2.get();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        },"T3").start();
//
//        new Thread(()->{
//            try {
//                phone2.get();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        },"T4").start();
    }
}
