package com.course.concurrent.c3.s03;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuzhenke
 * @date 2019/11/1
 */
public class LinkedBlockingQueueTest {

    @Test
    public void testEmptyPoll() {
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>(1);
        try {
            linkedBlockingQueue.poll(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
