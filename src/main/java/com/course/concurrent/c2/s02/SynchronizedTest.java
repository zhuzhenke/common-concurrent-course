package com.course.concurrent.c2.s02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhuzhenke
 * @date 2019/10/7
 */
public class SynchronizedTest {

    public static void main(String[] args) throws Exception {
        sellTickets();
        System.in.read();
    }

    private static int totalTickets = 10000;
    private static final Object LOCK = new Object();

    private static void sellTickets() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable runnableA = () -> {
            int threadATickets = 0;
            while (sellTicketsWithSyncMethod(1)) {
                threadATickets++;
            }
            System.out.println("Thread A buys " + threadATickets + " tickets");
        };

        Runnable runnableB = () -> {
            int threadBTickets = 0;
            while (sellTicketsWithSyncMethod(1)) {
                threadBTickets++;
            }
            System.out.println("Thread B buys " + threadBTickets + " tickets");
        };

        executorService.execute(runnableA);
        executorService.execute(runnableB);
    }

    /**
     * 方法级别使用synchronized关键字，synchronized方法
     *
     * @param count 卖票数量
     * @return 剩余票数是否足够
     */
    private static synchronized boolean sellTicketsWithSyncMethod(int count) {
        if (totalTickets - count < 0) {
            return false;
        } else {
            totalTickets = totalTickets - count;
            return true;
        }
    }

    /**
     * 某个对象级别使用synchronized关键字，synchronized代码块
     *
     * @param count 卖票数量
     * @return 剩余票数是否足够
     */
    private static boolean sellTicketsWithSyncObject(int count) {
        synchronized (LOCK) {
            if (totalTickets - count < 0) {
                return false;
            } else {
                totalTickets = totalTickets - count;
                return true;
            }
        }
    }
}
