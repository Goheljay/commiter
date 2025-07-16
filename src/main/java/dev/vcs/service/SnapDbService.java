package dev.vcs.service;

import java.util.List;

public interface SnapDbService {
    void addFirstFlowOfFiles(String path, String branchId, String commitId);

    List<String> getProjectFileSnapshot(String rootPath);
}
