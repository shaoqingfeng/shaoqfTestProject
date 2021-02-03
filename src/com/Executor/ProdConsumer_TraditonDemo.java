package com.Executor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ProdConsumer_TraditonDemo
 * @Description: TODO
 * @Author: shaoqf
 * @Date: 2021/2/3 6:48
 * *题目:一个初始值为零的变量，两个线程对其交替操作，一个加1一个减1，来5轮加1
 * 1 线程  操作(方法)  资源类
 * 2 判断  干活
 * 通知  防止虚假唤醒机制
 * 多线程循环判断必须用 while 不能用if ，2个线程if可以，大于2个线程会出现异常，API文档中有详细 说明
 * 原因：
 * 在线程中notify或者notifyAll会唤醒一个或多个线程，当线程被唤醒后，被唤醒的线程继续执行阻塞后的操作。
 *
 * 这里分析一下get操纵： 当某个线程得到锁时number为0，此时它应该wait，下次被唤醒时（任意线程调用notify），
 * number可能还是0的。因为有可能其他线程清空了number。如果此时用的是if它将不再判断number是否为空，
 * 直接继续，这样就引起了错误。但如果用while则每次被唤醒时都会先检查number是否为空【0】再继续，这样才是正确的操作；生产也是同一个道理。
 * @Version: 1.0
 */
class  ShareData{
    private  int number =0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment(){
        lock.lock();
        try {
            //判断
            while (number !=0){
                condition.await();
            }
            //do it
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            //判断
            while (number ==0){
                condition.await();
            }
            //do it
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class ProdConsumer_TraditonDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(()->{
            for (int i = 1; i <=5 ; i++) {
                try {
                    shareData.increment();
                    System.out.println("^生产第"+i+"轮");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        },"AA").start();

        new Thread(()->{
            for (int i = 1; i <=5 ; i++) {
                try {
                    shareData.decrement();
                    System.out.println("^消费第"+i+"轮");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"BB").start();


        new Thread(()->{
            for (int i = 1; i <=5 ; i++) {
                try {
                    shareData.increment();
                    System.out.println("^生产第"+i+"轮");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        },"CC").start();

        new Thread(()->{
            for (int i = 1; i <=5 ; i++) {
                try {
                    shareData.decrement();
                    System.out.println("^消费第"+i+"轮");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"DD").start();
    }



}
