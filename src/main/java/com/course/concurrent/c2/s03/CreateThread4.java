package com.course.concurrent.c2.s03;

import java.util.concurrent.*;

/**
 * @author zhuzhenke
 * @date 2019/10/11
 */
public class CreateThread4 {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //1 execute Runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread running");
            }
        };
        executorService.execute(runnable);

        //2 submit Runnable
        Future runnableFuture = executorService.submit(runnable);
        Object futureObject = runnableFuture.get();
        System.out.println("futureObject = " + futureObject);

        //3 submit callable
        Callable callable = new MyCallable();
        Future<String> future = executorService.submit(callable);
        String result = future.get();
        System.out.println("future result : " + result);
    }

    public static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("calling");
            return "calling";
        }
    }
}
