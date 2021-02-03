package com.Executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 多线程后台处理工具类
 * @Author: wangkun_oup@sitech.com.cn
 * @Date: 2019/12/13 22:42
 */
public class MultiThreadService<T> {

    /**
     * 多线程提交执行方法
     * @param namePrefix 线程名称前缀
     * @param threadNum  线程个数
     * @param task       执行任务
     * @return
     * @throws Exception 异常
     */
    public List<T> confirmTask(String namePrefix,Integer threadNum,ExecutorTask<T> task) throws Exception {
        CountDownLatch downLatch = new CountDownLatch(threadNum);
        task.setCdl(downLatch);
        ExecutorService service = new ThreadPoolExecutor(threadNum, threadNum,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(200),
                getThreadFactory(namePrefix));
        List<FutureTask<T>> taskList = new ArrayList<>();

        for(int i=0;i<threadNum;i++){
            FutureTask<T> futureTask = new FutureTask(task);
            taskList.add(futureTask);
            service.submit(futureTask);

        }

        downLatch.await();
        List<T> resultList = new ArrayList<>();
        for(FutureTask<T> futureTask: taskList){
           resultList.add(futureTask.get());
        }
        service.shutdown();
        return resultList;

    }

    /**
     * 线程工厂
     * @param namePrefix 线程前缀
     * @return
     */
    private ThreadFactory getThreadFactory(String namePrefix){
        return new DefaultThreadFactory(namePrefix);
    }

    /**
     * 默认线程工厂
     */
    private class DefaultThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory(String namePrefix) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            this.namePrefix = namePrefix + "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }


}
