package dev.vcs.entity;

import java.util.Date;

public class BranchModal {
    private String id;
    private String branchName;
    private String parentBranchId;
    private Date createdAt;

    @Override
    public String toString() {
        return "BranchModal{" +
                "id='" + id + '\'' +
                ", branchName='" + branchName + '\'' +
                ", parentBranchId='" + parentBranchId + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public BranchModal(String id, String branchName, String parentBranchId, Date createdAt) {
        this.id = id;
        this.branchName = branchName;
        this.parentBranchId = parentBranchId;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getParentBranchId() {
        return parentBranchId;
    }

    public void setParentBranchId(String parentBranchId) {
        this.parentBranchId = parentBranchId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
