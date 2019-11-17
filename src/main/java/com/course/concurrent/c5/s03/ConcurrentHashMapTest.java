package com.course.concurrent.c5.s03;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhuzhenke
 * @date 2019/11/16
 */
public class ConcurrentHashMapTest {
    @Test
    public void testHashMapUse() {
        Map<Integer, User> userMap = new ConcurrentHashMap<>();

        User zhangsan = new User(1, "zhangsan");
        User lisi = new User(2, "lisi");
        userMap.put(zhangsan.getUserId(), zhangsan);
        userMap.put(lisi.getUserId(), lisi);

        User user1 = userMap.get(1);
        System.out.println(JSONObject.toJSONString(user1));

    }

    @Data
    public class User {
        private Integer userId;
        private String userName;

        public User(Integer userId, String userName) {
            this.userId = userId;
            this.userName = userName;
        }
    }
}
