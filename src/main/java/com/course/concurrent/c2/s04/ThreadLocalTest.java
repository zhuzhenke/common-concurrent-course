package com.course.concurrent.c2.s04;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhuzhenke
 * @date 2019/10/13
 */
public class ThreadLocalTest {

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
        UserSessionContext.getUserSessionContext().setUserId(userId);


        String info = getMyInfo();
        List<String> courses = getMyCourses();

        System.out.println(Thread.currentThread().getName() + "'s info = " + info
                + ";courses = " + JSONObject.toJSONString(courses));

        UserSessionContext.removeContext();
    }

    private static String getMyInfo() {
        return UserSessionContext.getUserSessionContext().getUserId() + " 的个人信息";
    }

    private static List<String> getMyCourses() {
        return Collections.singletonList(UserSessionContext.getUserSessionContext().getUserId() + " 的Java并发基础课程");
    }

    public static class UserSessionContext {
        private static ThreadLocal<UserSessionContext> threadLocal =
                ThreadLocal.withInitial(UserSessionContext::new);

        public static UserSessionContext getUserSessionContext() {
            return threadLocal.get();
        }

        public static void removeContext() {
            threadLocal.remove();
        }

        private Long userId;

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            System.out.println(Thread.currentThread().getName() + " set userId = " + userId);
            this.userId = userId;
        }
    }

}
