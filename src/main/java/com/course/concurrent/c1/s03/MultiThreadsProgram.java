package com.course.concurrent.c1.s03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhuzhenke
 * @date 2019/10/3
 */
public class MultiThreadsProgram {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        int start = 1;
        int end = 100;
        executorService.execute(() -> {
            int sum1 = count(start, end);
            System.out.println("sum1=" + sum1);
        });


        executorService.execute(() -> {
            int sum2 = count2(start, end);
            System.out.println("sum2=" + sum2);
        });
    }

    private static int count(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    private static int count2(int start, int end) {
        return (start + end) * (end - start + 1) / 2;
    }

}
