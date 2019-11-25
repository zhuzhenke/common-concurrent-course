package com.course.concurrent.c5.s04;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author zhuzhenke
 * @date 2019/11/19
 */
public class CopyOnWriteArrayListTest {

    @Test
    public void testArrayListConcurrentModificationException() {
        List<Integer> integerList = new ArrayList<>();
        addElementWhenIterator(integerList);
    }

    private void addElementWhenIterator(List<Integer> integerList) {
        integerList.add(1);
        integerList.add(2);

        Iterator<Integer> iterator = integerList.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            integerList.add(next + 100);
        }
        System.out.println(JSONObject.toJSONString(integerList));
    }

    @Test
    public void testCopyOnWriteArrayListConcurrentModificationException() {
        List<Integer> integerList = new CopyOnWriteArrayList<>();
        addElementWhenIterator(integerList);
    }




}
