package com.course.concurrent.c2.s02;

/**
 * @author zhuzhenke
 * @date 2019/10/8
 */
public class BuildSingleObject {
    private static volatile BuildSingleObject object;

    private BuildSingleObject() {
    }

    public static BuildSingleObject buildSingleInstance() {
        if (object == null) {
            synchronized (BuildSingleObject.class) {
                if (object == null) {
                    object = new BuildSingleObject();
                }
            }
        }
        return object;
    }
}
