package com.dryseed.javademo.jvm;

/**
 * 类的初始化时机
 */
public class Demo1 {
    static {
        System.out.println("静态初始化Demo01");
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Demo01的main方法！");
        //System.out.println(System.getProperty("java.class.path"));

        //主动引用（一定会发生类的初始化）
//        new A();
//        System.out.println(A.width);
//        Class.forName("com.dryseed.dryseedapp.test.jvm.A"); //反射调用也会触发类的初始化
		/*
		    log:
                静态初始化Demo01
                Demo01的main方法！
                静态初始化A_Father
                静态初始化类A
                创建A类的对象
                300
		 */


        //被动引用（不会发生类的初始化）
//		System.out.println(A.MAX);
//		A[] as = new A[10]; //通过数组定义类引用，不会触发此类的初始化
        System.out.println(B.width);
        /*
            没有打印“静态初始化B”
            log:
                静态初始化Demo01
                Demo01的main方法！
                静态初始化A_Father
                静态初始化类A
                300

         */
    }
}

class B extends A {
    static {
        System.out.println("静态初始化B");
    }
}

class A extends A_Father {
    public static int width = 100;   //静态变量，静态域    field
    public static final int MAX = 100;

    static {
        System.out.println("静态初始化类A");
        width = 300;
    }

    public A() {
        System.out.println("创建A类的对象");
    }
}

class A_Father extends Object {
    static {
        System.out.println("静态初始化A_Father");
    }
}

