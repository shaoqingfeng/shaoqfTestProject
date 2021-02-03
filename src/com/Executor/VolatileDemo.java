package com.Executor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: mythread
 * @Description: TODO
 * @Author: shaoqf
 * @Date: 2019/12/15 15:46
 * @Version: 1.0
 */
  class   Mydata{
      int number =0;
    public void addNumber(){
        this.number=60;
    }

    public  void  addPlusNumber(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public  void  addAtomNumber(){
        atomicInteger.getAndIncrement();
    }
}
public class VolatileDemo {


    /**
     *1验证volatile的可见性
     *1.1 假如int number = 0; , number变量之前根本没有添加volatile关键字修饰,没有可见性1.2添加了volatile，可以解决可见性问题。
     *
     *验证volatile不保证原子性
     *2.1原子性指的是什么意思?
     * 不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加塞或者被分割。需要整体完整要么同时成功，要么同时失败。|
     I
     *
     */


    public static void main(String[] args) throws Exception {
//        seeOkByVolatile();



    }

    //可以保证可见性，及时通知
    private static void seeOkByVolatile() {
        //         验证可见性
        Mydata mydata = new Mydata();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mydata.addNumber();
            System.out.println(Thread.currentThread().getName()+"\t update number value >>>"+mydata.number);
        },"AAAA").start();

        //第二个线程 main 线程
        while (mydata.number==0){

//            System.out.println(Thread.currentThread().getName()+"\t qqqqqqq 0000000000");

        }

        System.out.println(Thread.currentThread().getName()+"\t  miss over"+ mydata.number);
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
