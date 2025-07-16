package dev.vcs.service;

import dev.vcs.entity.FileDiffModal;

public interface DirService {
    void createFolder(String path, String s);

    void addFileDiff(String rootPath, String filePath, FileDiffModal initialDiff);
}
