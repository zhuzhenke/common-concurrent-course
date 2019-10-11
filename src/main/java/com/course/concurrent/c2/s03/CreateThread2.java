package com.course.concurrent.c2.s03;

/**
 * @author zhuzhenke
 * @date 2019/10/11
 */
public class CreateThread2 {

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread running");
        }
    }
}
