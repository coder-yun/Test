package com.yun.junit.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

/**
 * Created by caiyunwu on 2017/3/23.
 */
public class ErrorCollectorTest {
    @Rule
    public final ErrorCollector errorCollector = new ErrorCollector();

    @Test
    public void testErrorCollector() {
        System.out.println("testErrorCollector");
        errorCollector.addError(new Throwable("first went wrong"));
        errorCollector.addError(new Throwable("second went wrong"));
    }
}
