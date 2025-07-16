package dev.vcs.serviceImpl;

import com.google.gson.Gson;
import dev.vcs.entity.DiffDbModal;
import dev.vcs.entity.FileDiffModal;
import dev.vcs.service.DirService;
import dev.vcs.utils.UtilsEnums;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;

public class DirServiceImpl implements DirService {
    private static DirServiceImpl obj = null;

    public static synchronized DirServiceImpl getInstance() {
        if (obj == null) {
            obj = new DirServiceImpl();
        }
        return obj;
    }

    @Override
    public void createFolder(String path, String s) {
        //create commiter Repository
        File rootDir = new File(path);
        if (!rootDir.isDirectory()) {
            throw new RuntimeException("Is Not folder"); // folder is Not found
        }
        File createFolderPath = new File(path, s);
        if (!createFolderPath.mkdir()){
            throw new RuntimeException("Folder already exists"); // folder creation failed
        }
    }

    public static String encode(String input) {
        byte[] encodedBytes = Base64.getEncoder().encode(input.getBytes());
        return new String(encodedBytes);
    }

    @Override
    public void addFileDiff(String rootPath, String filePath, FileDiffModal initialDiff) {
        String encodedName = encode(filePath);
        File file = new File(rootPath+ UtilsEnums.DIFFS_ROUTE, encodedName);
        try {
            if (file.exists()) {
                var diffDB = new Gson().fromJson(Files.readString(file.toPath()), DiffDbModal.class);
                if (diffDB.getDiffModels() == null) {
                    diffDB.setDiffModels(new ArrayList<>());
                }
                //Remove diffModel if same index exist
                FileDiffModal toRemove = null;
                for (FileDiffModal d : diffDB.getDiffModels()) {
                    if (d.getId().equals(initialDiff.getId())) {
                        toRemove = d;
                        break;
                    }
                }

                if (toRemove != null) {
                    diffDB.getDiffModels().remove(toRemove);
                }

                //Add new one
                initialDiff.setInitCommit(false);
                diffDB.getDiffModels().add(initialDiff);

                try (FileWriter fileWriter = new FileWriter(file)) {
                    fileWriter.write(new Gson().toJson(diffDB));
                }
            } else {
                var diffDB = new DiffDbModal();
                initialDiff.setInitCommit(true);
                diffDB.getDiffModels().add(initialDiff);
                file.createNewFile();
                try (FileWriter fileWriter = new FileWriter(file)) {
                    fileWriter.write(new Gson().toJson(diffDB));
                }
            }
        } catch(IOException e) {

        }
    }
}
