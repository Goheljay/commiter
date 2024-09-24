package dev.vcs.service;

import dev.vcs.entity.SnapshotDetailsEntity;

public interface SnapDbService {
    void addFirstFlowOfFiles(String path, SnapshotDetailsEntity snapShotDbDto);
}
