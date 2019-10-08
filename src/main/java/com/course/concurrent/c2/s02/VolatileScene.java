package com.course.concurrent.c2.s02;

/**
 * @author zhuzhenke
 * @date 2019/10/8
 */
public class VolatileScene {
    private volatile boolean isFinished = false;

    public void finish() {
        isFinished = true;
    }

    public void work() {
        while (!isFinished) {
            //working
            System.out.println("working");
        }
    }
}
