package com.course.concurrent.c3.s05;

import com.alibaba.fastjson.parser.Feature;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zhuzhenke
 * @date 2019/11/4
 */
public class ThreadPoolCallableTest {
    @Test
    public void testCallable() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Callable<String> callable =
                () -> {
                    return "callable-result";
                };

        Future<String> future = executorService.submit(callable);

        if (future.isDone()) {
            System.out.println("future result is : " + future.get());
        }


    }
}
