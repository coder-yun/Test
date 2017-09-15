package com.yun.junit.category;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by caiyunwu on 2017/3/27.
 */
@Category({SlowTests.class,FastTests.class})
public class B {
    @Test
    public void d(){
        System.out.println("class B,category:SlowTests.class,FastTests.classmethod d");
    }
}
