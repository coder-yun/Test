package com.yun.junit.category;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by caiyunwu on 2017/3/27.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(SlowTests.class)
//@Categories.ExcludeCategory(FastTests.class)
@Suite.SuiteClasses({A.class,B.class}) // Note that Categories is a kind of Suite
public class SlowTestSuit {
    // Will run A.b, but not A.a or B.c
}
