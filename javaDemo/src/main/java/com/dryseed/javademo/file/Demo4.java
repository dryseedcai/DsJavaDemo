package com.dryseed.javademo.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import static com.dryseed.javademo.file.Demo3.test3;

/**
 * 5、操作目录
 * mkdir() 创建目录，必须确保 父目录存在，如果不存在，创建失败
 * mkdirs() 创建目录，如果父目录链不存在一同创建
 * list() 文件|目录 名字符串形式
 * listFiles()
 * static listRoots() 根路径
 *
 * @author Administrator
 */
public class Demo4 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }

    public static void test3() {
        String path = "./javaDemo/src/main/java/com/dryseed/javademo/file/test.text";
        File src = new File(path);
        try {
            src.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        String path = "E:/xp/test/";
        File src = new File(path); //文件夹
        if (src.isDirectory()) { //存在并且为目录
            System.out.println("======子目录|文件名===");
            String[] subNames = src.list();
            for (String temp : subNames) {
                System.out.println(temp);
            }

            System.out.println("=====子目录|文件File对象====");
            File[] subFiles = src.listFiles();
            for (File temp : subFiles) {
                System.out.println(temp.getAbsolutePath());
            }

            System.out.println("=====子文件.java对象====");
            //命令设计模式
            subFiles = src.listFiles(new FilenameFilter() {
                @Override
                /**
                 * dir 代表src
                 */
                public boolean accept(File dir, String name) {
                    //System.out.println(dir.getAbsolutePath());
                    return new File(dir, name).isFile() && name.endsWith(".java");
                }
            });
            for (File temp : subFiles) {
                System.out.println(temp.getAbsolutePath());
            }

        }
    }

    public static void test1() {
        String path = "E:/xp/test/parent/p/test";
        File src = new File(path);
        //src.mkdir();
        src.mkdirs();
    }

}
