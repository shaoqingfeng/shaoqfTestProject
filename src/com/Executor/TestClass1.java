package com.Executor;


import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: TODO
 * @Author: wangkun_oup@sitech.com.cn
 * @Date: 2019/12/13 21:04
 */
public class TestClass1 {
    @Test
    public void test(){
        MultiThreadService<String> service = new MultiThreadService();
        List<String> list = null;
        long begin = System.currentTimeMillis();
        try {
            list = service.confirmTask("my",5,new MyTask());
            long end = System.currentTimeMillis();
            System.out.println("耗时："+(end-begin));
            System.out.println("==========================");
            for (String s : list) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"hello...");
            }
        });
        service.submit(new Runnable() {
            @Override
            public void run() {
                int x = 5/0;
                System.out.println(Thread.currentThread().getName()+"hello...");
            }
        });
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"hello...");
            }
        });

        int i=0;
        while (i<50){
            ThreadPoolExecutor tpe = (ThreadPoolExecutor)service;
            int queueSize = tpe.getQueue().size();
            System.out.println("当前排队线程数：" + queueSize);

            int activeCount = tpe.getActiveCount();
            System.out.println("当前活动线程数：" + activeCount);

            long completedTaskCount = tpe.getCompletedTaskCount();
            System.out.println("执行完成线程数：" + completedTaskCount);

            long taskCount = tpe.getTaskCount();
            System.out.println("总线程数：" + taskCount);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    class MyTask extends ExecutorTask<String>{
        @Override
        public String doTask() {
            Random random = new Random();
            int time = random.nextInt(5);
            try {
                TimeUnit.SECONDS.sleep(time);
                int x = 5/0;
            }catch (Exception e){
                return e.getMessage();
            }
            return Thread.currentThread().getName()+":hello world...wait["+time+"s]";
        }
    }

}
