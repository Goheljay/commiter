package dev.vcs.entity.commit;

import java.util.ArrayList;

public class CommitDb {
    private ArrayList<CommitEntity> commitEntities;

    public void addCommit(CommitEntity entity) {
        if (commitEntities == null) {
            commitEntities = new ArrayList<>();
        }
        commitEntities.add(entity);

    }

    public CommitDb() {
    }

    public void setCommitEntities(ArrayList<CommitEntity> commitEntities) {
        this.commitEntities = commitEntities;
    }

    public CommitDb(ArrayList<CommitEntity> commitEntities) {
        this.commitEntities = commitEntities;
    }

    public ArrayList<CommitEntity> getCommitEntities() {
        return commitEntities;
    }
}
