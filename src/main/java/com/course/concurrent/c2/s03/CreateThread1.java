package com.course.concurrent.c2.s03;

/**
 * @author zhuzhenke
 * @date 2019/10/11
 */
public class CreateThread1 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread running");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

}
