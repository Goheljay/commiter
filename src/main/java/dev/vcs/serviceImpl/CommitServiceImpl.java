package dev.vcs.serviceImpl;

import com.google.gson.Gson;
import dev.vcs.entity.commit.CommitDb;
import dev.vcs.entity.commit.CommitEntity;
import dev.vcs.service.CommitService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class CommitServiceImpl implements CommitService {
    private static CommitServiceImpl obj = null;

    public static CommitServiceImpl getInstance() {
        if (obj == null) {
            obj = new CommitServiceImpl();
        }
        return obj;
    }

    @Override
    public void initialCommit(String rootPath, CommitEntity commitEntity) {
        File commitFile = new File(rootPath + "/branches/" + commitEntity.getBranchId() + "/commitsDb.json");
        CommitDb commitDB;
        try {
            if (!commitFile.exists()) {

                commitFile.createNewFile();
                commitDB = new CommitDb();
            } else {
                commitDB = new Gson().fromJson(Files.readString(commitFile.toPath()), CommitDb.class);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        commitDB.addCommit(commitEntity);
        try (FileWriter fileWriter = new FileWriter(commitFile)) {
            fileWriter.write(new Gson().toJson(commitDB));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
