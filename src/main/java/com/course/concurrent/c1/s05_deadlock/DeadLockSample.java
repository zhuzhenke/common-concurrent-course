package com.course.concurrent.c1.s05_deadlock;

/**
 * @author zhuzhenke
 * @date 2019/10/5
 */
public class DeadLockSample {

    private final static Object lock1 = new Object();
    private final static String lock2 = new String();


    public static void main(String[] args) throws Exception {
        newThread("ThreadA", lock1, lock2).start();

        newThread("ThreadB", lock2, lock1).start();

        System.in.read();
    }

    private static Thread newThread(String threadName, Object lockFirst, Object lockSecond) {
        return new Thread(() -> {
            synchronized (lockFirst) {
                System.out.println(Thread.currentThread().getName() + " holding lockFirst");
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " waiting lockSecond");
                synchronized (lockSecond) {
                    System.out.println(Thread.currentThread().getName() + " holding lockSecond");
                }

            }
        }, threadName);
    }
}
