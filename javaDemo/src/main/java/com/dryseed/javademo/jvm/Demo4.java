package com.dryseed.javademo.jvm;

/**
 * 线程上下文类加载器的测试
 */
public class Demo4 {
    public static void main(String[] args) throws Exception {
        ClassLoader loader = Demo4.class.getClassLoader();
        System.out.println(loader);


        ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
        System.out.println(loader2);

        String path = "javaDemo/src/main/java";
        Thread.currentThread().setContextClassLoader(new FileSystemClassLoader(path));
        System.out.println(Thread.currentThread().getContextClassLoader());

        Class<Demo1> c = (Class<Demo1>) Thread.currentThread().getContextClassLoader().loadClass("com.dryseed.javademo.jvm.Demo1");
        System.out.println(c);
        System.out.println(c.getClassLoader()); //这里还是AppClassLoader是因为FileSystemClassLoader定义了父类委派机制，给了AppClassLoader

        /*
            log:
                sun.misc.Launcher$AppClassLoader@18b4aac2
                sun.misc.Launcher$AppClassLoader@18b4aac2
                com.dryseed.javademo.jvm.FileSystemClassLoader@74a14482
                class com.dryseed.javademo.jvm.Demo1
                sun.misc.Launcher$AppClassLoader@18b4aac2
         */
    }
}
