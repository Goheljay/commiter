package dev.vcs.entity.commit;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class CommitEntity {
    private UUID id;
    private String commitMessage;
    private String branchId;
    private ArrayList<String> parentCommitId;
    private Date createdAt;

    @Override
    public String toString() {
        return "CommitEntity{" +
                "commitId=" + id +
                ", commitMessage='" + commitMessage + '\'' +
                ", branchId='" + branchId + '\'' +
                ", parentCommitId=" + parentCommitId +
                ", createdAt=" + createdAt +
                '}';
    }

    public CommitEntity(String commitMessage, String branchId, ArrayList<String> parentCommitId, Date createdAt) {
        this.id = UUID.randomUUID();;
        this.commitMessage = commitMessage;
        this.branchId = branchId;
        this.parentCommitId = parentCommitId;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCommitMessage() {
        return commitMessage;
    }

    public void setCommitMessage(String commitMessage) {
        this.commitMessage = commitMessage;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public ArrayList<String> getParentCommitId() {
        return parentCommitId;
    }

    public void setParentCommitId(ArrayList<String> parentCommitId) {
        this.parentCommitId = parentCommitId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
