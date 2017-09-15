package com.yun.concurrence;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by iWM on 2017/2/3.
 */
public class ThreadTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue(100);
        try {
            abq.put("a");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
