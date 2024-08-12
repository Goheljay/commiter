package dev.vcs.serviceImpl;

import dev.vcs.entity.RepoEntity;
import dev.vcs.entity.SnapshotDetailsEntity;
import dev.vcs.service.*;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepoServiceImpl implements RepoService {
    private static final Logger log = Logger.getLogger(RepoServiceImpl.class);
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
        // create Branch
        BranchService branchService = BranchServiceImpl.getInstance();
        String branchId = branchService.createBranch(rootPath);
        //create Branches folder
        dirService.createFolder(rootPath, "branches");
        //create branchId Folder
        dirService.createFolder(rootPath+"/branches", branchId);
        //create Diff Folder
        dirService.createFolder(rootPath, "diffs");
        //create CommitDb File
        fileRService.createRepoFile(rootPath, new RepoEntity());
        //create Repo File
        RepoEntity repoEntity = generateRepoEntity(creatorName, branchId);
        fileRService.createRepoFile(rootPath, repoEntity);
        //Manage the SnapDbJson file
        SnapDbService snapDbService = SnapDbServiceImpl.getInstance();
        snapDbService.addFirstFlowOfFiles(path);
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
