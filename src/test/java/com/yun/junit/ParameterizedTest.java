package com.yun.junit;

import com.yun.common.Calculator;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by caiyunwu on 2017/3/22.
 */
@RunWith(Parameterized.class)
public class ParameterizedTest {
    @Parameterized.Parameter(0)
    public int expectedSum;
    @Parameterized.Parameter(1)
    public  int a;
    @Parameterized.Parameter(2)
    public int b;

//    public CalculatorTest(int expectSum, int a, int b) {
//        this.expectedSum=expectSum;
//        this.a=a;
//        this.b=b;
//    }
    @Parameters(name="{index}:sum({1},{2})={0}")
    public static Iterable<Object[]> addTestData(){
        return Arrays.asList(new Object[][]{{3, 1, 2}, {5, 2, 3}, {8, 2, 8}, {5, 1, 4}});
    }

    @org.junit.Test
    public void testSum() throws Exception {
        System.out.println("test sum with parameters:"+a+" and "+b);
        Calculator cal=new Calculator();
        assertEquals(expectedSum,cal.sum(a,b));
    }
}