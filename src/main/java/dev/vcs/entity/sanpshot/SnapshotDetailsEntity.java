package dev.vcs.entity.sanpshot;

import dev.vcs.utils.MyUtils;

import java.util.List;

public class SnapshotDetailsEntity {
    //branchId ... commitId
    private String id;
    private List<String> files;
    private String commitId;
    private String branchId;

    public SnapshotDetailsEntity() {
    }

    public SnapshotDetailsEntity(List<String> files, String commitId, String branchId) {
        this.id = MyUtils.generateSnapId(branchId, commitId);
        this.files = files;
        this.commitId = commitId;
        this.branchId = branchId;
    }

    @Override
    public String toString() {
        return "SnapshotDetailsEntity{" +
                "snapshotId='" + id + '\'' +
                ", files=" + files +
                ", commitId='" + commitId + '\'' +
                ", branchId='" + branchId + '\'' +
                '}';
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public String getCommitId() {
        return commitId;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }
}
