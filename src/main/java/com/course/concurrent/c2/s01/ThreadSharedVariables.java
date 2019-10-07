package com.course.concurrent.c2.s01;

/**
 * @author zhuzhenke
 * @date 2019/10/7
 */
public class ThreadSharedVariables {

    private static int a = 0;

    public static void main(String[] args) throws Exception {
        Thread threadA = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " a = " + a);
            a = 1;
            System.out.println(Thread.currentThread().getName() + " a = " + a);
        }, "ThreadA");


        Thread threadB = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " a = " + a);
            a = 1;
            System.out.println(Thread.currentThread().getName() + " a = " + a);
        }, "ThreadB");

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("a = " + a);
    }


}
