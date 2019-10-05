package com.course.concurrent.c1.s01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuzhenke
 * @date 2019/9/26
 */
public class FinalUse {
    private final int finalInt = 1;

    private final List<Integer> finalIntList = new ArrayList<Integer>();

    public void assignValueToFinalVariable() {
        //Cannot assign a value to a final variable 'finalInt'
//        finalInt = 2;

        //can add Integer value
        finalIntList.add(1);
        finalIntList.add(2);

        //new List
        List<Integer> tempIntList = new ArrayList<Integer>();
        tempIntList.add(1);
        tempIntList.add(2);

        //Cannot assign a value to a final variable 'finalIntList'
//        finalIntList = tempIntList;

    }
}
