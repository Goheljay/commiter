package dev.vcs.utils;

public enum UtilsEnums {
    COMMITER_ROUTE("/.commiter"),
    COMMITER(".commiter"),
    BRANCHES_ROUTE("/branches"),
    BRANCHES("branches"),
    DIFFS_ROUTE("/diffs"),
    DIFFS("diffs");

    private final String value;

    UtilsEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
