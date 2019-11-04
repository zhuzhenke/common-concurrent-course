package com.course.concurrent.c3.s05;

import com.alibaba.fastjson.parser.Feature;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author zhuzhenke
 * @date 2019/11/4
 */
public class ThreadPoolCallableTest {


    @Test
    public void testGetTicketsInfo() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        int taskNum = 10;
        long mainStart = System.currentTimeMillis();
        List<Future<String>> futureList = new ArrayList<>();
        for (int taskIndex = 0; taskIndex < taskNum; taskIndex++) {
            Callable<String> callable =
                    () -> {
                        long start = System.currentTimeMillis();
                        long sleep = new Random().nextInt(5000);
                        Thread.sleep(sleep);
                        System.out.println(Thread.currentThread().getName() + " cost " + (System.currentTimeMillis() - start));
                        return "Airline-company-result-";
                    };
            Future<String> future = executorService.submit(callable);
            futureList.add(future);
        }

        for (Future<String> future : futureList) {
            try {
                String airlineResult = future.get(3, TimeUnit.SECONDS);
                System.out.println("Future result : " + airlineResult);
            } catch (Throwable th) {
                th.printStackTrace();
            }

        }
        System.err.println(Thread.currentThread().getName() + " cost " + (System.currentTimeMillis() - mainStart));

    }


    @Test
    public void testDoNotUseFuture() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Callable<String> callable =
                () -> {
                    long start = System.currentTimeMillis();
                    long sleep = new Random().nextInt(3000);
                    Thread.sleep(sleep);
                    System.out.println(Thread.currentThread().getName() + " cost " + (System.currentTimeMillis() - start));
                    return "Airline-company-result-1";
                };

        Future<String> future = executorService.submit(callable);

        String result = future.get();
        System.out.println(result);

    }
}
