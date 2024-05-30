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
        FileRService fileRService = FileRServiceImpl.getInstance();
        //created .commiter Folder
        dirService.createFolder(path, ".commiter");
        var rootPath = path+"/.commiter";
        //create Diff Directory
        dirService.createFolder(rootPath, "diffs");

        // create Branch
        BranchService branchService = BranchServiceImpl.getInstance();
        String branchId = null;
        try {
            branchId = branchService.createBranch(rootPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //create Branches folder
        dirService.createFolder(rootPath, "branches");
        //create branchId Folder
        dirService.createFolder(rootPath+"/branches", branchId);
        //create CommitDb File
        fileRService.createRepoFile(path, null);
        //create Repo File
        RepoEntity repoEntity = generateRepoEntity(creatorName, branchId);
        fileRService.createRepoFile(path, repoEntity);
    }

    private RepoEntity generateRepoEntity(String creatorName, String branch) {
        RepoEntity repoEntity = new RepoEntity();
        repoEntity.setCreatedAt(new Date());
        repoEntity.setCreatedBy(creatorName);
        repoEntity.setActiveBranch(branch);
        repoEntity.setInitialBranch(branch);
        repoEntity.setActiveCommit(null);
        repoEntity.setInitialCommit(null);
        repoEntity.setProjectName("commiter");
        return repoEntity;
    }
}
