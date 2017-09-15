package com.yun.junit.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

/**
 * Created by caiyunwu on 2017/3/23.
 */
public class TimeoutTest {
    public static String log;
    @Rule
    public final TestRule globalTimeout = Timeout.seconds(5);

    @Test
    public void testInfiniteLoop1() {
        log += "ran1";
        for (; ; ) {
        }
    }

    @Test
    public void testInfiniteLoop2() {
        log += "ran2";
        for (; ; ) {

        }
    }
}
