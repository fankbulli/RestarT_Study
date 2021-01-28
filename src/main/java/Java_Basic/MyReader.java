/*
 * Copyright (c) 2020. Shanghai TongYan Civil Engineering Technology Corp., Ltd. All rights reserved.
 */
package Java_Basic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Description: 一句话描述此类
 *
 * @author 钟鸣
 * @Date 2020/10/29 17:21
 */
public abstract class MyReader extends InputStream {
    protected FileInputStream is;
    public MyReader(FileInputStream stream){
        this.is=stream;
    }

    public List<String> getLine(int i){
        BufferedReader reader=null;
        List<String> list=new ArrayList<>();
        try {
            reader=new BufferedReader(new InputStreamReader(is));
            String s="";
            while (null!=(s=reader.readLine())){
                if (!"<R>".equals(s)){
                    String[] strings=s.split(";");
                    list.add(strings[i]);
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}

class CodeReader extends MyReader{

    public CodeReader(FileInputStream stream) {
        super(stream);
    }

    @Override
    public int read() throws IOException {
        List<String> list=this.getLine(0);
        System.out.println("工号如下：");
        if (null!=list&&list.size()>0){
            for (String s:list){
                String[] strings=s.split(":");
                System.out.println(strings[1]);
            }
        }
        return 0;
    }
}

class NameReader extends MyReader{
    public NameReader(FileInputStream stream) {
        super(stream);
    }
    @Override
    public int read() throws IOException {
        List<String> list=this.getLine(1);
        System.out.println("姓名如下：");
        if (null!=list&&list.size()>0){
            for (String s:list){
                String[] strings=s.split(":");
                System.out.println(strings[1]);
            }
        }
        return 0;
    }
}

class BirthReader extends MyReader{


    public BirthReader(FileInputStream stream) {
        super(stream);
    }

    @Override
    public int read() throws IOException {
        List<String> list=this.getLine(2);
        System.out.println("生日如下：");
        if (null!=list&&list.size()>0){
            for (String s:list){
                String[] strings=s.split(":");
                System.out.println(strings[1]);
            }
        }
        return 0;
    }
}


class AddReader extends MyReader{

    public AddReader(FileInputStream stream) {
        super(stream);
    }

    @Override
    public int read() throws IOException {
        List<String> list=this.getLine(3);
        System.out.println("地址如下：");
        if (null!=list&&list.size()>0){
            for (String s:list){
                String[] strings=s.split(":");
                String add=strings[1].split("\\]")[1].split("\\[")[1];
                System.out.println(add);
            }
        }
        return 0;
    }
}

class PostReader extends MyReader{
    public PostReader(FileInputStream stream) {
        super(stream);
    }

    @Override
    public int  read() {
        List<String> list=this.getLine(3);
        System.out.println("邮编如下：");
        if (null!=list&&list.size()>0){
            for (String s:list){
                String[] strings=s.split(":");
                String post=strings[1].split("\\[")[2].split("\\]")[1];
                System.out.println(post);
            }
        }
        return 0;
    }
}

