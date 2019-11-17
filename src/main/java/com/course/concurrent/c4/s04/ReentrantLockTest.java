package com.course.concurrent.c4.s04;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhuzhenke
 * @date 2019/11/16
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                try {
                    reentrantLock.lock();
                    System.out.println(Thread.currentThread().getName() + " acquire lock...");
                    Thread.sleep(new Random().nextInt(3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                    System.out.println(Thread.currentThread().getName() + " release lock...");
                }

            };
            new Thread(runnable).start();
        }
    }
}
