package com.course.concurrent.c2.s05;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuzhenke
 * @date 2019/10/14
 */
public class WeakReferenceTest {
    public static void main(String[] args) throws Exception {

        testSoftReferenceNoDirectReference();

        testWeakReferenceNoDirectReference();

        testWeakReferenceWithDirectReference();
    }

    /**
     * 测试SoftReference，SoftReference引用的对象并没有被其他对象直接引用
     */
    private static void testSoftReferenceNoDirectReference() throws Exception {
        Object obj = new Object();
        SoftReference<Object> softRef = new SoftReference<>(obj);
        System.out.println(softRef.get());

        obj = null;

        System.gc();
        Thread.sleep(3000L);

        System.out.println(softRef.get());
    }


    /**
     * 测试WeakReference，WeakReference引用的对象并没有被其他对象直接引用
     */
    private static void testWeakReferenceNoDirectReference() throws Exception {
        Object obj = new Object();
        WeakReference<Object> weakRef = new WeakReference<>(obj);
        System.out.println(weakRef.get());

        obj = null;

        System.gc();
        Thread.sleep(3000L);

        System.out.println(weakRef.get());
    }

    /**
     * 测试WeakReference，WeakReference引用的对象并没有被其他对象直接引用
     */
    private static void testWeakReferenceWithDirectReference() throws Exception {
        Object obj = new Object();
        WeakReference<Object> weakRef = new WeakReference<>(obj);
        System.out.println(weakRef.get());

        List<Object> objectList = new ArrayList<>();
        objectList.add(obj);

        obj = null;

        System.gc();
        Thread.sleep(3000L);

        System.out.println(weakRef.get());
    }
}
