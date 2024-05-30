package dev.vcs.service;

import dev.vcs.entity.RepoEntity;

public interface FileRService {
    void createRepoFile(String path, RepoEntity repoEntity);
}
