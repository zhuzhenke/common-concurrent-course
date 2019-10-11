package com.course.concurrent.c2.s03;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zhuzhenke
 * @date 2019/10/11
 */
public class CreateThread3 {

    public static void main(String[] args) throws Exception {
        Callable<String> callable = new GetThreadResult.MyCallable();
        FutureTask<String> futureTask = new FutureTask(callable);

        new Thread(futureTask).start();

        String result = futureTask.get();
        System.out.println("result = " + result);
    }

    public static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("calling");
            return "calling";
        }
    }
}
