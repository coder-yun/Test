package com.yun.junit.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.startsWith;

/**
 * Created by caiyunwu on 2017/3/23.
 */
public class ExpectedExceptionTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void throwsNothing() {

    }

    @Test
    public void throwsnullPointerException() {
        thrown.expect(NullPointerException.class);
        throw new NullPointerException("123");
    }

    @Test
    public void throwsNullPointerExceptionWithMessage() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("happened");
        thrown.expectMessage(startsWith("What"));
        throw new NullPointerException("1What happened?");
    }
}
