package com.yun.junit.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;

/**
 * Created by caiyunwu on 2017/3/23.
 */
public class TemporaryFolderTest {
    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testUsingTemporaryFolder() throws Exception {
        File creadeFile = folder.newFile("myfile");
    }
}
