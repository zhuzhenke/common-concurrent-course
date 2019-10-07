package com.course.concurrent.c2.s01;

/**
 * @author zhuzhenke
 * @date 2019/10/7
 */
public class ThreadReordering {

    private static int a = 0;
    private static int b = 0;

    private static int x = 0;
    private static int y = 0;

    public static void main(String[] args) throws Exception {
        Thread threadA = new Thread(() -> {
            b = 1;
            x = a;
        }, "ThreadA");


        Thread threadB = new Thread(() -> {
            a = 1;
            y = b;
        }, "ThreadB");

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("x = " + x + " ; y = " + y);
    }


}
