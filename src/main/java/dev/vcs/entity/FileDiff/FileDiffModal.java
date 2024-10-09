package dev.vcs.entity.FileDiff;

import dev.vcs.utils.MyUtils;

import java.util.ArrayList;

public class FileDiffModal {
    private String id;
    private ArrayList<String> diff;
    private String branchId;
    private String commitId;
    private Boolean isInitCommit;

    public FileDiffModal(ArrayList<String> diff, String branchId, String commitId, Boolean isInitCommit) {
        this.id = MyUtils.generateSnapId(branchId, commitId);;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
