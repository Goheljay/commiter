package dev.vcs.service;

import dev.vcs.entity.commit.CommitEntity;

public interface CommitService {
    String initialCommit(String rootPath, CommitEntity commitEntity);
}
