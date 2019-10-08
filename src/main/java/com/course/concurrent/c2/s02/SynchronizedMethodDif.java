package com.course.concurrent.c2.s02;

/**
 * @author zhuzhenke
 * @date 2019/10/7
 */
public class SynchronizedMethodDif {

    /**
     * 锁是控制是在类级别的，静态方法一般是"类.方法"的调用方式
     */
    private static synchronized void soutStatic() {
        System.out.println(Thread.currentThread().getName() + " is sleeping ");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : 1");
        System.out.println(Thread.currentThread().getName() + " finish sleeping ");
    }

    /**
     * 锁的控制是在对象级别的，对于同一个类的两个对象，它们可以同时执行，并不会相互影响
     */
    private synchronized void soutNonStatic() {
        System.out.println(Thread.currentThread().getName() + " is sleeping ");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : 1");
        System.out.println(Thread.currentThread().getName() + " finish sleeping ");
    }


//    public static void main(String[] args) throws Exception {
//        nonStaticTest();
//        staticTest();
//        System.in.read();
//    }
//
//
//    private static void nonStaticTest() {
//        SynchronizedMethodDif dif1 = new SynchronizedMethodDif();
//        SynchronizedMethodDif dif2 = new SynchronizedMethodDif();
//        new Thread(() -> {
//            dif1.soutNonStatic();
//        }, "Thread-dif1").start();
//
//        new Thread(() -> {
//            dif2.soutNonStatic();
//        }, "Thread-dif2").start();
//    }
//
//    private static void staticTest() {
//        new Thread(() -> {
//            soutStatic();
//        }, "Thread-dif1").start();
//
//        new Thread(() -> {
//            soutStatic();
//        }, "Thread-dif2").start();
//    }


}
