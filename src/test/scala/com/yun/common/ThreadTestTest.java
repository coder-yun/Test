package com.yun.common;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by iWM on 2017/2/3.
 */
public class ThreadTestTest {
    @Test
    public void add() throws Exception {
        int z= new ThreadTest().add(3,4);
        assertThat(z,is(7));
    }

    @Test
    public  void mutlitTest() throws Exception{
        int z=new ThreadTest().multi(3,4 );
        assertThat(z,is(11));
    }
}