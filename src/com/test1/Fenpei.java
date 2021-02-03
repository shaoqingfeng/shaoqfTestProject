package com.test1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: fenpei
 * @Description: TODO
 * @Author: shaoqf
 * @Date: 2019/12/14 8:43
 * @Version: 1.0
 */

public class Fenpei {

        static List<Integer> listCus = new ArrayList<Integer>();

        static List<String> persons = new ArrayList<String>();

        // static Map<String, String> result = new HashMap<String, String>();
        static List<Persons> result = new ArrayList<Persons>();

        /**
         * @param args
         */
        public static void main(String[] args) {

            int k = 0;
            List l = new ArrayList();

            // 发、数量
            for (int i = 0; i < 20; i++) {
                listCus.add(i);
            }
            // 人
            for (int j = 0; j < 5; j++) {
                persons.add("person" + j);
            }

            // System.out.println(persons.size());

            int personSize = persons.size();

            for (int i = 0; i < listCus.size(); i++) {
                // System.out.println(i);
                // System.out.println(persons.get(i%personSize));
                Persons p = new Persons();
                p.setI(i);
                p.setPersonname(persons.get(i % personSize));
                result.add(p);
            }
            Iterator it = result.iterator();

            while (it.hasNext()) {
                Persons p = (Persons) it.next();
                System.out.println("哪个人 => " + p.getI() + " 分配到 "
                        + p.getPersonname());
            }

            // for (int j = 1; j < persons.size() + 1; j++) {
            // System.out.println(j);
            // }

        }

        public static class Persons {
            private Integer i;

            private String personname;

            public Integer getI() {
                return i;
            }

            public void setI(Integer i) {
                this.i = i;
            }

            public String getPersonname() {
                return personname;
            }

            public void setPersonname(String personname) {
                this.personname = personname;
            }
        }

    }


