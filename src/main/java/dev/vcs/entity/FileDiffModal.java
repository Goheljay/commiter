package dev.vcs.entity;

import java.util.ArrayList;
import java.util.UUID;

public class FileDiffModal {
    private UUID id;
    private ArrayList<String> diff;
    private String branchId;
    private String commitId;
    private Boolean isInitCommit;

    public FileDiffModal(UUID id, ArrayList<String> diff, String branchId, String commitId, Boolean isInitCommit) {
        this.id = id;
        this.diff = diff;
        this.branchId = branchId;
        this.commitId = commitId;
        this.isInitCommit = isInitCommit;
    }

    @Override
    public String toString() {
        return "FileDiffModal{" +
                "id=" + id +
                ", diff=" + diff +
                ", branchId='" + branchId + '\'' +
                ", commitId='" + commitId + '\'' +
                ", isInitCommit=" + isInitCommit +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ArrayList<String> getDiff() {
        return diff;
    }

    public void setDiff(ArrayList<String> diff) {
        this.diff = diff;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getCommitId() {
        return commitId;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    public Boolean getInitCommit() {
        return isInitCommit;
    }

    public void setInitCommit(Boolean initCommit) {
        isInitCommit = initCommit;
    }
}
