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
