package com.yun.junit.rule;

import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static org.junit.Assert.fail;

/**
 * Created by caiyunwu on 2017/3/23.
 */
public class TestWatcherTest {
    private static String watchedLog="";
    @Rule
    public final TestRule watchman = new TestWatcher() {
        @Override
        public Statement apply(Statement base, Description description) {
            System.out.println("apply");
            return super.apply(base, description);
        }

        @Override
        protected void succeeded(Description description) {
            System.out.println("succeeded");
            watchedLog += description.getDisplayName() + " " + "success!\n";
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println("failed");
            watchedLog += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            System.out.println("skipped");
            watchedLog += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
        }

        @Override
        protected void starting(Description description) {
            super.starting(description);
            System.out.println("starting");
        }

        @Override
        protected void finished(Description description) {
            super.finished(description);
            System.out.println("finished");
            System.out.println(watchedLog);
        }
    };

    @Test
    public void fails() {
        fail();
    }

    @Test
    public void succeeds() {
    }

}


