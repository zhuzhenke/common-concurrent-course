package com.course.concurrent.c1.s04;

/**
 * @author zhuzhenke
 * @date 2019/10/3
 */
public class ThreadSleep {

    public static Object object = new Object();

    public static void main(String[] args) throws Exception {

        newThread("ThreadA").start();

        newThread("ThreadB").start();

        System.in.read();
    }

    private static Thread newThread(String threadName) {
        return new Thread(() -> {
            synchronized (object) {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    if (i == 10) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " start to sleep");
                            Thread.sleep(1000L);
                            System.out.println(Thread.currentThread().getName() + " finished sleeping");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, threadName);
    }
}
