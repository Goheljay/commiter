package dev.vcs.entity.FileDiff;

import dev.vcs.entity.commit.CommitEntity;

import java.util.ArrayList;

public class FileDiffDb {
    private ArrayList<FileDiffModal> fileDiffModals;

    public void addCommit(FileDiffModal entity) {
        if (fileDiffModals == null) {
            fileDiffModals = new ArrayList<>();
        }
        fileDiffModals.add(entity);

    }

    public ArrayList<FileDiffModal> getFileDiffModals() {
        return fileDiffModals;
    }

    public void setFileDiffModals(ArrayList<FileDiffModal> fileDiffModals) {
        this.fileDiffModals = fileDiffModals;
    }
}
