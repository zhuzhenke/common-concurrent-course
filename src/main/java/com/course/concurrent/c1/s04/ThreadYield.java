package com.course.concurrent.c1.s04;

import org.junit.Test;

/**
 * @author zhuzhenke
 * @date 2019/10/3
 */
public class ThreadYield {

    public static void main(String[] args) throws Exception {
        newThread("ThreadA").start();

        newThread("ThreadB").start();

        System.in.read();
    }


    private static Thread newThread(String threadName) {
        return new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                if (i == 10) {
                    Thread.yield();
                }
            }
        }, threadName);
    }
}
