package com.Executor;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @Description: 任务类实现了Callable接口
 * @Author: wangkun_oup@sitech.com.cn
 * @Date: 2019/12/13 22:36
 */
public class ExecutorTask<T> implements Callable<T> {
    private CountDownLatch cdl;

    @Override
    public T call() {
        T t = doTask();
        return t;
    }

    public T doTask(){
        return null;
    }

    public CountDownLatch getCdl() {
        return cdl;
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }
}
