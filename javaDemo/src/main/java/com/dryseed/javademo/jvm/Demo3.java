package com.dryseed.javademo.jvm;

import java.io.File;

/**
 * 测试自定义的FileSystemClassLoader
 */
public class Demo3 {
    public static void main(String[] args) throws Exception {
        String path = "javaDemo/src/main/java";
        File filePath = new File(path);
        System.out.println(filePath.getAbsolutePath());

        FileSystemClassLoader loader = new FileSystemClassLoader(path);
        FileSystemClassLoader loader2 = new FileSystemClassLoader(path);
        System.out.println(loader.hashCode() + " " + loader2.hashCode());

        Class<?> c1 = loader.loadClass("com.dryseed.javademo.jvm.HelloWorld");
        Class<?> c2 = loader.loadClass("com.dryseed.javademo.jvm.HelloWorld");
        Class<?> c3 = loader2.loadClass("com.dryseed.javademo.jvm.HelloWorld");

        Class<?> c4 = loader2.loadClass("java.lang.String");
        Class<?> c5 = loader2.loadClass("com.dryseed.javademo.jvm.Demo1");


        System.out.println("c1 hashCode:" + c1.hashCode());
        System.out.println("c2 hashCode:" + c2.hashCode());
        System.out.println("c3 hashCode:" + c3.hashCode());    //同一个类，被不同的加载器加载，JVM认为是不相同的类（这里是同一个，因为都是同一个类加载器AppClassLoader）
        System.out.println("c4 hashCode:" + c4.hashCode());
        System.out.println("c3 ClassLoader:" + c1.getClassLoader());    //自定义的类加载器
        System.out.println("c4 ClassLoader:" + c4.getClassLoader());    //引导类加载器
        System.out.println("c5 ClassLoader:" + c5.getClassLoader());    //系统默认的类加载器

        /*
            如果使用项目外部的class类，则不会被AppClassLoader拦截，将调用FileSystemClassLoader自定义类加载器
            log:
                1956725890
                1956725890
                1956725890
                356573597
                null
                sun.misc.Launcher$AppClassLoader@18b4aac2
                sun.misc.Launcher$AppClassLoader@18b4aac2
         */

    }
}
