package com.dryseed.javademo.jvm;

/**
 * 测试类加载器的层次结构、双亲委托机制
 */
public class Demo2 {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());   //JAVA_HOME/jre/lib/rt.jar
        //System.out.println(System.getProperty("java.class.path"));

        System.out.println("################");
        String a = "gaogao";
        System.out.println(a.getClass().getClassLoader());
        System.out.println(a);

        /*
            log:
                sun.misc.Launcher$AppClassLoader@63961c42
                sun.misc.Launcher$ExtClassLoader@5b2133b1
                null
                ################
                null
                gaogao
         */
    }
}

