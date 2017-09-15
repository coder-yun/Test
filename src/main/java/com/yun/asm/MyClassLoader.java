package com.yun.asm;

/**
 * Created by caiyunwu on 2017/9/14.
 */
public class MyClassLoader extends ClassLoader {
    public Class defineClass(String  name,byte[] b) {
        return defineClass(name, b, 0, b.length);
    }
}
