package dev.vcs.serviceImpl;

import com.google.gson.Gson;
import dev.vcs.entity.RepoEntity;
import dev.vcs.service.FileRService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Date;
import java.util.logging.Logger;

public class FileRServiceImpl implements FileRService {
    private static FileRServiceImpl obj = null;
    static Logger log = Logger.getLogger(FileRServiceImpl.class.getName());

    public static synchronized FileRServiceImpl getInstance() {
        if (obj == null) {
            obj = new FileRServiceImpl();
        }
        return obj;
    }


    @Override
    public void createRepoFile(String path, RepoEntity repoEntity ) {
        File createFile = new File(path+"/.commiter","Repo.json");
        try {
            if (!createFile.createNewFile()){
                throw new FileAlreadyExistsException("File already Exists");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter commiterRepoWriter = new FileWriter(createFile)) {
            String repoEntityJson = new Gson().toJson(repoEntity);
            commiterRepoWriter.write(repoEntityJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
