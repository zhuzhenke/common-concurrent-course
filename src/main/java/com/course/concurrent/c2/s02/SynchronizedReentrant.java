package com.course.concurrent.c2.s02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhuzhenke
 * @date 2019/10/7
 */
public class SynchronizedReentrant {
    private static Object LOCK = new Object();

    public static void main(String[] args) {
        reentrant();
    }


    private static void reentrant() {
        synchronized (LOCK) {
            System.out.println("hold Lock");
            synchronized (LOCK) {
                System.out.println("hold Lock again");
            }
        }
    }


    private static void useReentantLock() {
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println("hold Lock");
        } finally {
            lock.unlock();
        }
    }
}
