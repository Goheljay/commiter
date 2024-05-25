package dev.vcs.entity;

import java.util.Date;

public class RepoEntity {
    private String projectName;
    private Long initialCommit;
    private Long initialBranch;
    private Long activeCommit;
    private Long activeBranch;
    private String createdBy;
    private Date createdAt;

    public RepoEntity(String projectName, Long initialCommit, Long initialBranch, Long activeCommit, Long activeBranch, String createdBy, Date createdAt) {
        this.projectName = projectName;
        this.initialCommit = initialCommit;
        this.initialBranch = initialBranch;
        this.activeCommit = activeCommit;
        this.activeBranch = activeBranch;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "RepoEntity{" +
                "projectName='" + projectName + '\'' +
                ", initialCommit=" + initialCommit +
                ", initialBranch=" + initialBranch +
                ", activeCommit=" + activeCommit +
                ", activeBranch=" + activeBranch +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getInitialCommit() {
        return initialCommit;
    }

    public void setInitialCommit(Long initialCommit) {
        this.initialCommit = initialCommit;
    }

    public Long getInitialBranch() {
        return initialBranch;
    }

    public void setInitialBranch(Long initialBranch) {
        this.initialBranch = initialBranch;
    }

    public Long getActiveCommit() {
        return activeCommit;
    }

    public void setActiveCommit(Long activeCommit) {
        this.activeCommit = activeCommit;
    }

    public Long getActiveBranch() {
        return activeBranch;
    }

    public void setActiveBranch(Long activeBranch) {
        this.activeBranch = activeBranch;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
