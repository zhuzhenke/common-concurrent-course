package com.course.concurrent.c3.s01;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhuzhenke
 * @date 2019/10/28
 */
public class ThreadPoolCreateTest {


    @Test
    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " running");
        });
    }
}
