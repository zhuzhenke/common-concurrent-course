package com.course.concurrent.c2.s04;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhuzhenke
 * @date 2019/10/13
 */
public class NoThreadLocalTest {

    public static void main(String[] args) {
        sampleTest();
    }

    /**
     * 模拟场景：HTTP服务端使用多线程处理来自不同用户的请求
     */
    private static void sampleTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            Long userId = 10000L;
            doUseRequest(userId);
        });

        executorService.submit(() -> {
            Long userId = 20000L;
            doUseRequest(userId);
        });
    }

    private static void doUseRequest(Long userId) {
        ThreadContext threadContext = new ThreadContext();
        threadContext.setUserId(userId);

        String info = getMyInfo(threadContext);
        List<String> courses = getMyCourses(threadContext);

        System.out.println("info = " + info
                + ";courses = " + JSONObject.toJSONString(courses));
    }

    private static String getMyInfo(ThreadContext threadContext) {
        return threadContext.getUserId() + " 的个人信息";
    }

    private static List<String> getMyCourses(ThreadContext threadContext) {
        return Collections.singletonList(threadContext.getUserId() + " 的Java并发基础课程");
    }

    @Data
    public static class ThreadContext {
        private Long userId;
    }
}
