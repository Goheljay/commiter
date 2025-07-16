package dev.vcs.entity;

import java.util.List;

public class DiffDbModal {
    List<FileDiffModal> diffModels;

    public List<FileDiffModal> getDiffModels() {
        return diffModels;
    }

    public void setDiffModels(List<FileDiffModal> diffModels) {
        this.diffModels = diffModels;
    }
}
