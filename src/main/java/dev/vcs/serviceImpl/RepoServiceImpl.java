package dev.vcs.serviceImpl;

import dev.vcs.entity.RepoEntity;
import dev.vcs.service.BranchService;
import dev.vcs.service.DirService;
import dev.vcs.service.FileRService;
import dev.vcs.service.RepoService;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class RepoServiceImpl implements RepoService {
    private static RepoServiceImpl obj = null;

    public static synchronized RepoServiceImpl getInstance() {
        if (obj == null) {
            obj = new RepoServiceImpl();
        }
        return obj;
    }

    @Override
    public void initializeTheRepo(String path, String creatorName) {
        DirService dirService = DirServiceImpl.getInstance();

        //created .commiter Folder
        dirService.createFolder(path, ".commiter");

        //create Diff Directory
        dirService.createFolder(path+"/.commiter", "diffs");


        // create Branch
        BranchService branchService = BranchServiceImpl.getInstance();
        String branch = null;
        try {
            branch = branchService.createBranch(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        RepoEntity repoEntity = new RepoEntity();
        repoEntity.setCreatedAt(new Date());
        repoEntity.setCreatedBy(creatorName);
        repoEntity.setActiveBranch(branch);
        repoEntity.setInitialBranch(branch);
        repoEntity.setActiveCommit(null);
        repoEntity.setInitialCommit(null);
        repoEntity.setProjectName("commiter");

        //create Repo File
        FileRService fileRService = FileRServiceImpl.getInstance();
        fileRService.createRepoFile(path, repoEntity);
    }
}
