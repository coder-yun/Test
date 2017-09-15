package com.yun.junit.rule;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

/**
 * Created by caiyunwu on 2017/3/24.
 */
public class AssumeTest {
    public static int flag=1;
    @Test
    public void assumeTest() {
        assumeThat(flag,is(2));
        assertThat(flag+1,is(2));
    }
}
