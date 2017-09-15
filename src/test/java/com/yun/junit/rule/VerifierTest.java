package com.yun.junit.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;

import static org.junit.Assert.assertEquals;

/**
 * Created by caiyunwu on 2017/3/23.
 */
public class VerifierTest {
    private static String sequence = "test";
    @Rule
    public final Verifier collector = new Verifier() {
        @Override
        protected void verify() throws Exception {
            if (sequence.length() < 10) {
                throw new Exception("verify failed");
            }
        }
    };

    @Test
    public void verifierRunsAfterTest() {
        assertEquals("test", sequence);
    }
}
