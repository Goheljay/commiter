package dev.vcs.serviceImpl;

import dev.vcs.entity.FileDiffModal;
import dev.vcs.entity.commit.CommitEntity;
import dev.vcs.entity.RepoEntity;
import dev.vcs.service.*;
import dev.vcs.utils.UtilsEnums;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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
        var rootPath = path+ UtilsEnums.COMMITER_ROUTE;
        // create Branch
        BranchService branchService = BranchServiceImpl.getInstance();
        String branchId = branchService.createBranch(rootPath);
        //create Branches folder
        dirService.createFolder(rootPath, UtilsEnums.BRANCHES.getValue());
        //create branchId Folder
        dirService.createFolder(rootPath+"/branches", branchId);
        //create Diff Folder
        dirService.createFolder(rootPath, UtilsEnums.DIFFS.getValue());

        //create CommitDb File
        CommitService commitService = CommitServiceImpl.getInstance();
        CommitEntity commitEntity = generateCommit(branchId);
        String commitId = commitService.initialCommit(rootPath, commitEntity);

        //Manage the SnapDbJson file
        SnapDbService snapDbService = SnapDbServiceImpl.getInstance();
        snapDbService.addFirstFlowOfFiles(path, branchId, commitId);


        List<String> filePaths = snapDbService.getProjectFileSnapshot(rootPath);


        //after generate snapshot create diff modal
        // Iterate filePaths from snapshot of initial commit for creating fileDiff
        try {
            for (String filePath : filePaths) {
                // Read the content from the project for each file
                String diff = Files.readString(Path.of(rootPath + filePath));

                // Create an initial Diff model for filePath
                FileDiffModal initialDiff = new FileDiffModal(diff, branchId, commitId, true);
                // Create DiffDB for the filePath and adds initialDiff to it
                dirService.addFileDiff(rootPath, filePath, initialDiff);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //create Repo File
        //TODO: Once all task complete comment out it.
        RepoEntity repoEntity = generateRepoEntity(creatorName, branchId, commitId);
        fileRService.createRepoFile(rootPath, repoEntity);
        //Manage the SnapDbJson file
//        SnapDbService snapDbService = SnapDbServiceImpl.getInstance();
//        snapDbService.addFirstFlowOfFiles(path, branchId, commitId);
    }

    private RepoEntity generateRepoEntity(String creatorName, String branch, String commitId) {
        RepoEntity repoEntity = new RepoEntity();
        repoEntity.setCreatedAt(new Date());
        repoEntity.setCreatedBy(creatorName);
        repoEntity.setActiveBranch(branch);
        repoEntity.setInitialBranch(branch);
        repoEntity.setActiveCommit(commitId);
        repoEntity.setInitialCommit(commitId);
        repoEntity.setProjectName("commiter");
        return repoEntity;
    }

    private CommitEntity generateCommit(String branchId) {
        return new CommitEntity("Initial Commit",branchId,new ArrayList<>(), new Date());
    }
}
