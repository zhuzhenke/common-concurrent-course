package com.course.concurrent.c1.s04;

/**
 * @author zhuzhenke
 * @date 2019/10/4
 */
public class ObjectWait {

    private static Object lock = new Object();

    public static void main(String[] args) throws Exception {
        newThread("ThreadA").start();

        newThread("ThreadB").start();

        System.in.read();
    }

    private static Thread newThread(String threadName) {
        return new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    lock.notifyAll();
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    try {
                        System.out.println(Thread.currentThread().getName() + " wait 开始");
                        lock.wait();
                        System.out.println(Thread.currentThread().getName() + " wait 结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, threadName);
    }
}
