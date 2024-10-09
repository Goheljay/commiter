package dev.vcs.utils;

import java.util.UUID;

public class MyUtils {
    public UUID  generateUUID() {
        return UUID.randomUUID();
    }

    public static String generateSnapId(String commitId, String branchId) {
        return branchId+"..."+commitId;
    }
}
