package com.yun.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by caiyunwu on 2017/3/22.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({UnitTest.class, ParameterizedTest.class})
public class SuitTest {
}
