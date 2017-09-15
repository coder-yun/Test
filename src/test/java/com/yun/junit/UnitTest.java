package com.yun.junit;

import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

/**
 * Created by caiyunwu on 2017/3/22.
 */
public class UnitTest {
    @BeforeClass
    public static void beforeClassTest() throws Exception {
        System.out.println("BeforeClass");
    }

    @AfterClass
    public static void afterClassTest() throws Exception {
        System.out.println("afterclass");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("before");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void test1() throws Exception {
        System.out.println("test test1");
        int[] arr = new int[3];
        System.out.println(arr[10]);
    }

    @Test(timeout = 1000)
    public void test2() throws Exception {
        Thread.sleep(2000);
        System.out.println("test test2");
    }

    @Ignore("test Ignore annotation")
    @Test
    public void test3() throws Exception {
        System.out.println("test test3");
    }

    @Test
    public void assertTest() throws Exception {
//        assertEquals("test error", 123, 145, 3);
        assertEquals("1",1,2,4);
//        assertTrue("assertTrue",false);
        System.out.println("test assertEquals");
        assertEquals("object  equals",new String("1"),new String("1"));
//        assertSame("object same",new String("1"),new String("1"));
    }

}