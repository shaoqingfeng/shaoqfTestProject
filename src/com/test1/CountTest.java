package com.test1;

import java.util.Calendar;
import java.util.Date;

public class CountTest {
    public static void main(String[] args) {
        encode("wwwbbawabbb");
        encode("a");
        encode("abcabcccc");
        encode("ppppprrrrppp");
        encode("");
        encode(null);
    }

    public static void encode(String str) {
        if (str == null || str.equals("")) {
            System.out.println("");
            return;
        }

        // 利用StringBuffer变量字符串接受结果
        StringBuffer sb = new StringBuffer();
        
        char element = str.charAt(0);
        
        byte[]  element2 =   str.getBytes();
        
        System.out.println("element=="+element);
        
        System.out.println("element2=="+element2.toString());
        int count=1;
        for(int i=1;i<str.length();i++) {
            System.out.println("element=="+element+",charAt(i)=="+str.charAt(i));

            if(element==str.charAt(i)) {
                count++;
            }else {
                //当读到另一个不一样的字符的时候，再拼接之前统计的字符
                sb.append(element);
                //如果统计数量为1的时候不输出统计数量
                sb.append(count==1 ? "" :count);
                element = str.charAt(i);
                count=1;
            }
        }
        // 保证当最后一个字符和统计的数量都拼接上
        sb.append(element);
        sb.append(count==1 ? "" :count);
        
        // 输出整个结果
        System.out.println(sb.toString());

        long aa = 2;
        long bb = aa > 0 ? 0 : (-1) * aa;
        System.out.println("bb=="+bb);

        Date date=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -15);
        Date qryTime=calendar.getTime();

        System.out.println("qryTime=="+qryTime);


    }
}