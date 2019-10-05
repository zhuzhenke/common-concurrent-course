package com.course.concurrent.c1.s01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhuzhenke
 * @date 2019/9/27
 */
public class SellTickets {


    public static void main(String[] args) {
//        sellNotThreadSafe();
        sellThreadSafe();
    }

    private static int totalTickets = 10000;

    private static void sellNotThreadSafe() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable runnableA = new Runnable() {
            int threadATickets = 0;
            public void run() {
                while (totalTickets > 0) {
                    totalTickets--;
                    threadATickets++;
                }
                System.out.println("Thread A buys " + threadATickets + " tickets");
            }
        };

        Runnable runnableB = new Runnable() {

            public void run() {
                int threadBTickets = 0;
                while (totalTickets >= 0) {
                    totalTickets--;
                    threadBTickets++;
                }
                System.out.println("Thread B buys " + threadBTickets + " tickets");
            }
        };

        executorService.execute(runnableA);
        executorService.execute(runnableB);
    }


    private static AtomicInteger atomicTotalTickets = new AtomicInteger(10000);

    private static void sellThreadSafe() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable runnableA = new Runnable() {
            int threadATickets = 0;

            public void run() {
                while (atomicTotalTickets.get() > 0) {
                    atomicTotalTickets.decrementAndGet();
                    threadATickets++;
                }
                System.out.println("Thread A buys " + threadATickets + " tickets");

            }
        };

        Runnable runnableB = new Runnable() {

            public void run() {
                int threadBTickets = 0;
                while (atomicTotalTickets.get() > 0) {
                    atomicTotalTickets.decrementAndGet();
                    threadBTickets++;
                }
                System.out.println("Thread B buys " + threadBTickets + " tickets");
            }
        };

        executorService.execute(runnableA);
        executorService.execute(runnableB);
    }
}
