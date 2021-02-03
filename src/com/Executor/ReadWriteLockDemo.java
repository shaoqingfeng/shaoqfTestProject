package com.Executor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName: ReadWriteLockDemo
 * @Description: TODO
 * @Author: shaoqf
 * @Date: 2021/1/31 21:54
 * @Version: 1.0
 */

class MyCache{
    private volatile Map<String,Object> map =new HashMap<>();
    private    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void put(String key ,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 写入！"+key);
            map.put(key,value);
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName()+"\t 写入完成！" +key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 读取！"+key);
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成！" +result);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}

public class ReadWriteLockDemo {


    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1; i <5 ; i++) {
            final int tempInt = i;
            new Thread(()->{
                myCache.put(tempInt+"",tempInt+"");
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <5 ; i++) {
            final int tempInt = i;
            new Thread(()->{
                myCache.get(tempInt+"");
            },String.valueOf(i)).start();
        }


    }



}
