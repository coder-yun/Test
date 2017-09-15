package com.yun.junit.category;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by caiyunwu on 2017/3/27.
 */
public class C implements SlowTests{
    @Test
    public void Implementstest(){
        System.out.println("class C,method Implementstest");
    }
}
