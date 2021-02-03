package com.Executor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.concurrent.*;

/**
 * @ClassName: mythread
 * @Description: TODO
 * @Author: shaoqf
 * @Date: 2019/12/15 15:46
 * @Version: 1.0
 */

public class mythread {
    public static void main(String[] args) throws Exception {

        // 开始时间
        long start = System.currentTimeMillis();
        List<String> list = new ArrayList<String>();

        for (int i = 1; i <= 3000; i++) {
            list.add(i + "");
        }
        // 每500条数据开启一条线程
        int threadSize = 500;
        // 总数据条数
        int dataSize = list.size();
        // 线程数
        int threadNum = dataSize / threadSize + 1;
        // 定义标记,过滤threadNum为整数
        boolean special = dataSize % threadSize == 0;

        // 创建一个线程池
        ExecutorService exec = Executors.newFixedThreadPool(threadNum);
        // 定义一个任务集合
        List<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();
        Callable<Integer> task = null;
        List<String> cutList = null;

        // 确定每条线程的数据
        for (int i = 0; i < threadNum; i++) {
            if (i == threadNum - 1) {
                if (special) {
                    break;
                }
                cutList = list.subList(threadSize * i, dataSize);
            } else {
                cutList = list.subList(threadSize * i, threadSize * (i + 1));
            }
            // System.out.println("第" + (i + 1) + "组：" + cutList.toString());
            final List<String> listStr = cutList;
            task = new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    System.out.println(Thread.currentThread().getName() + "线程：" + listStr);
                    return 1;
                }
            };
            // 这里提交的任务容器列表和返回的Future列表存在顺序对应的关系
            tasks.add(task);
        }

        List<Future<Integer>> results = exec.invokeAll(tasks);

        for (Future<Integer> future : results) {
            System.out.println(future.get());
        }

        // 关闭线程池
        exec.shutdown();
        System.out.println("线程任务执行结束");
        System.err.println("执行任务消耗了 ：" + (System.currentTimeMillis() - start) + "毫秒");
    }




    public static void getTxt(String fileContent,String fileName,String path)throws Exception{
        File file = null;
        FileWriter fw = null;
        file = new File(path);
        if(!file.exists()){
            file.mkdirs();//如果文件夹不存在逐级创建文件夹
        }
        file =new File(path+fileName);//如果没有创建一个文件
        file.createNewFile();//创建新的文件
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        try {
            out.write(fileContent);//写入内容
            out.flush();//把缓存区内容压入文件
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();//关闭文件
        }
    }

    //分组号
    //分组号码
//
//    //分组后集合
//    Map<String, List<UrUsergroupmbrInfo>> groupResult= new LinkedHashMap<>();
//    String groupNo="" ;
//                for( int i = 0; i < iMemberSize; i++){
//        UrUsergroupmbrInfo urUsergroupmbrInfo = urUsergroupmbrInfoList.get(i);
//        // System.out.println(i);
//        // System.out.println(persons.get(i%personSize));
//
//        //分组号
//        //分组号码
//
//        groupNo = String.valueOf(i%iTread);
//
//        //对组号一样的进行再次分组
//        //对标签一样的叠加资费进行分组
//        List<UrUsergroupmbrInfo> tempList = groupResult.get(groupNo);
//        if(tempList ==null){
//            tempList = new ArrayList<>();
//            tempList.add(urUsergroupmbrInfo);
//            groupResult.put(groupNo, tempList);
//        } else{
//            tempList.add(urUsergroupmbrInfo);
//        }
}
