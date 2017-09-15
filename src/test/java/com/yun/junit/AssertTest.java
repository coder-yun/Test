package com.yun.junit;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by caiyunwu on 2017/3/24.
 */
public class AssertTest {

    @Test
    public void testAssertEquals() {
        assertEquals("failure - strings are not equal", "text", "text");
    }

    @Test
    public void testAsserTrue() {
        assertTrue("failure - should be true",true);
    }

    @Test
    public void testAssertThat(){
        assertThat("abcd",both(containsString("a")).and(containsString("b")));
    }

    @Test
    public void testAssertThatHasItems(){
        assertThat(Arrays.asList(new String[]{"one", "two", "three"}), hasItems("one", "two"));
    }

    @Test
    public void testAssertThatEveryItemContains() {
        assertThat(Arrays.asList(new String[]{"fun","ban","net"}),everyItem(containsString("n")));
    }

    @Test
    public void testAssertThatHamcrestCoreMatchers() {
        assertThat("good", allOf(equalTo("good"), startsWith("good")));
        assertThat("good", not(allOf(equalTo("good"),equalTo("bad"))));
        assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
        assertThat(7, not(CombinableMatcher.either(equalTo(3)).or(equalTo(4))));
        assertThat(new Object(), not(sameInstance(new Object())));
    }
}
