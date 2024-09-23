package dev.vcs.service;

import dev.vcs.entity.commit.CommitEntity;

public interface CommitService {
    void initialCommit(String rootPath, CommitEntity commitEntity);
}
