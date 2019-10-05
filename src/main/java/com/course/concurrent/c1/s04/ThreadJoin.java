package com.course.concurrent.c1.s04;

/**
 * @author zhuzhenke
 * @date 2019/10/3
 */
public class ThreadJoin {


    public static void main(String[] args) throws InterruptedException {
        Thread threadA = newThread("ThreadA");

        Thread threadB = newThread("ThreadB");

        threadA.start();
        threadB.start();

        threadA.join();
        System.out.println("等待ThreadA执行完毕/终止");

        threadB.join();
        System.out.println("等待ThreadB执行完毕/终止");

        System.out.println("主线程继续执行......");

    }

    private static Thread newThread(String threadName) {
        return new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                if (i == 2) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, threadName);
    }
}
