package dev.vcs.entity;

import java.util.Date;

public class RepoEntity {
    private String projectName;
    private String initialCommit;
    private String initialBranch;
    private String activeCommit;
    private String activeBranch;
    private String createdBy;
    private Date createdAt;

    @Override
    public String toString() {
        return "RepoEntity{" +
                "projectName='" + projectName + '\'' +
                ", initialCommit='" + initialCommit + '\'' +
                ", initialBranch='" + initialBranch + '\'' +
                ", activeCommit='" + activeCommit + '\'' +
                ", activeBranch='" + activeBranch + '\'' +
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

    public String getInitialCommit() {
        return initialCommit;
    }

    public void setInitialCommit(String initialCommit) {
        this.initialCommit = initialCommit;
    }

    public String getInitialBranch() {
        return initialBranch;
    }

    public void setInitialBranch(String initialBranch) {
        this.initialBranch = initialBranch;
    }

    public String getActiveCommit() {
        return activeCommit;
    }

    public void setActiveCommit(String activeCommit) {
        this.activeCommit = activeCommit;
    }

    public String getActiveBranch() {
        return activeBranch;
    }

    public void setActiveBranch(String activeBranch) {
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
