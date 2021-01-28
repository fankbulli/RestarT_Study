///*
// * Copyright (c) 2020. Shanghai TongYan Civil Engineering Technology Corp., Ltd. All rights reserved.
// */
//package Java_Basic;
//
//
//import java.io.*;
//
//public class Tes {
//    public static void main(String[] args) {
//        try {
//
//            //输出工号
//            MyReader code=new CodeReader(new InputStreamReader(new FileInputStream(new File("employee.txt")),"UTF-8"));
//            code.read();            //输出姓名
//            MyReader name=new NameReader(new InputStreamReader(new FileInputStream(new File("employee.txt")),"UTF-8"));
//            name.read();
//            //输出生日
//            MyReader birth=new BirthReader(new InputStreamReader(new FileInputStream(new File("employee.txt")),"UTF-8"));
//            birth.read();
//            //输出地址
//            MyReader add=new AddReader(new InputStreamReader(new FileInputStream(new File("employee.txt")),"UTF-8"));
//            add.read();
//            //输出邮编
//            MyReader post=new PostReader(new InputStreamReader(new FileInputStream(new File("employee.txt")),"UTF-8"));
//            post.read();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
