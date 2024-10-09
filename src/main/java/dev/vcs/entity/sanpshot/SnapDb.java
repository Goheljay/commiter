package dev.vcs.entity.sanpshot;

import java.util.ArrayList;
import java.util.List;

public class SnapDb {
    private ArrayList<SnapshotDetailsEntity> snapshotDetailsEntities;

    public void addCommit(SnapshotDetailsEntity entity) {
        if (snapshotDetailsEntities == null) {
            snapshotDetailsEntities = new ArrayList<>();
        }
        snapshotDetailsEntities.add(entity);

    }

    public SnapDb() {
        snapshotDetailsEntities = new ArrayList<>();
    }

    public List<SnapshotDetailsEntity> getSnapshotDetailsEntities() {
        return snapshotDetailsEntities;
    }
}
