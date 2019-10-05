package com.course.concurrent.c1.s02;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author zhuzhenke
 * @date 2019/9/28
 */
public class CallbackMain {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> submit = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("正在执行耗时任务......");
                return "success";
            }
        });
        System.out.println("正在做主线程的事情....");
        //获取异步结果
        String result = submit.get();
        System.out.println("拿到结果："+result);
    }


    public void startServer() throws Exception{
        int port = 8080;
        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();
    }


    public void startClient() throws Exception{
        Socket socket =new Socket("127.0.0.1",8080);
        BufferedWriter bufferedWriter =new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));

        String str="Hello";
        bufferedWriter.write(str);
    }
}
