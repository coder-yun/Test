package com.yun.junit.category;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.fail;

/**
 * Created by caiyunwu on 2017/3/27.
 */
public class A {
    @Test
    @Category(C.class)
    public void a() {
        System.out.println("class A, no category, method a");
    }

    @Category(SlowTests.class)
    @Test
    public void  b() {
        System.out.println("class A,category SlowTests.class,method b");
    }
    @Category(FastTests.class)
    public void c() {
        System.out.println("class A,category FastTests.class,method c");
    }
}
