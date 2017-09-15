package com.yun.git;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.errors.*;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by caiyunwu on 2017/7/27.
 */
public class GitHelper {
    private  final static Logger log = LoggerFactory.getLogger(GitHelper.class);


    public static void main(String[] args) {
//        gitClone("https://xiaolvyun.baidu.com/git/waimai/base/waimai-proto", "E://git_test/", "caiyunwu_iwaimai.baidu.com_waimai", "Cyw%%3511862");
        gitPull("E://git_test/", "caiyunwu_iwaimai.baidu.com_waimai", "Cyw%%3511862");

    }

    public static void gitClone(String remoteUrl, String localDir, String user, String password) {
        try {
            Git git = Git.cloneRepository()
                    .setURI(remoteUrl)
                    .setDirectory(new File(localDir))
                    .setCredentialsProvider(new UsernamePasswordCredentialsProvider(user, password))
                    .call();
        } catch (GitAPIException e) {
            e.printStackTrace();
        }
    }

    public static void gitPull(String loaclDir,String user, String password) {
        File repoGitDir = new File(loaclDir + "/.git");
        if (!repoGitDir.exists()) {
            log.error("Error! Not Exists : " + loaclDir);
        }
        Repository repo = null;
        try {
            repo = new FileRepository(new File(loaclDir));
            Git git = new Git(repo);
            PullCommand pullCommand = git.pull();
            pullCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(user, password)).call();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RefNotAdvertisedException e) {
            e.printStackTrace();
        } catch (NoHeadException e) {
            e.printStackTrace();
        } catch (TransportException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (InvalidRemoteException e) {
            e.printStackTrace();
        } catch (CanceledException e) {
            e.printStackTrace();
        } catch (WrongRepositoryStateException e) {
            e.printStackTrace();
        } catch (RefNotFoundException e) {
            e.printStackTrace();
        } catch (GitAPIException e) {
            e.printStackTrace();
        }

    }


}
