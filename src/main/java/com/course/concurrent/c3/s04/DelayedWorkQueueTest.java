package com.course.concurrent.c3.s04;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuzhenke
 * @date 2019/11/1
 */
public class DelayedWorkQueueTest {
    @Test
    public void testScheduledThreadPoolExecutor() throws Exception {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        scheduledExecutorService.execute(()->{});
        scheduledExecutorService.schedule(() -> {
            System.out.println("run schedule : now = " + System.currentTimeMillis());
        }, 3, TimeUnit.SECONDS);


//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            try {
//                Thread.sleep(500L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("run schedule at fixed rate : now = " + System.currentTimeMillis());
//        }, 3, 1, TimeUnit.SECONDS);

//        scheduledExecutorService.scheduleWithFixedDelay(() -> {
//            try {
//                Thread.sleep(500L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("run schedule at fixed rate : now = " + System.currentTimeMillis());
//        }, 3, 1, TimeUnit.SECONDS);


        System.in.read();
    }
}
