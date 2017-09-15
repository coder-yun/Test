package com.yun.junit.rule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExternalResource;

/**
 * Created by caiyunwu on 2017/3/23.
 */
public class ExternalResourceTest {


    @Before
    public void setUp() throws Exception {
        System.out.println("before");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @Rule
    public final ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            System.out.println("ExternalResource before");
        }

        @Override
        protected void after() {
            System.out.println("ExternalResource after");
        }
    };

    @Test
    public void testExternalResource() throws Exception {
        System.out.println("testExternalResource");
    }
}
