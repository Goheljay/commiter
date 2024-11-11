package dev.vcs.serviceImpl;

import com.google.gson.Gson;
import dev.vcs.entity.sanpshot.SnapDb;
import dev.vcs.entity.sanpshot.SnapshotDetailsEntity;
import dev.vcs.service.SnapDbService;
import dev.vcs.utils.UtilsEnums;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class SnapDbServiceImpl implements SnapDbService {

    static SnapDbServiceImpl obj = null;
    public static SnapDbServiceImpl getInstance() {
        if (obj == null) {
            obj = new SnapDbServiceImpl();
        }
        return obj;
    }

    @Override
    public void addFirstFlowOfFiles(String path, String commitId, String branchId) {
        List<String> projectFileSnapshot = getProjectFileSnapshot(path);
        SnapshotDetailsEntity snapshotDetailsEntity = new SnapshotDetailsEntity(projectFileSnapshot,branchId, commitId);
        generateSnapShotDBFile(path, snapshotDetailsEntity);
    }

    private void generateSnapShotDBFile(String path, SnapshotDetailsEntity snapShotDbDto) {
        SnapDb snapDb;
        File snapFile = new File(path + UtilsEnums.COMMITER_ROUTE.getValue() + UtilsEnums.SNAP_DB_ROUTE);
        try {
            if (!snapFile.exists()) {

                snapFile.createNewFile();
                snapDb = new SnapDb();
            } else {
                snapDb = new Gson().fromJson(Files.readString(snapFile.toPath()), SnapDb.class);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        snapDb.addCommit(snapShotDbDto);
        try (FileWriter fileWriter = new FileWriter(snapFile)) {
            fileWriter.write(new Gson().toJson(snapDb));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> getProjectFileSnapshot(String path) {
        List<String> filePaths = getProjectFilesPath(path);
        List<String> unwantedPaths = new ArrayList<>();
        filePaths.forEach(s -> {
            if (s.contains("/.commiter")) {
                unwantedPaths.add(s);
            }
        });
        filePaths.removeAll(unwantedPaths);
        return filePaths;
    }

    public List<String> getProjectFilesPath(String projectDir) {
        String basePath = "";
        return getProjectFilesPath(projectDir, basePath);
    }

    private List<String> getProjectFilesPath(String projectDir, String basePath) {
        List<String> filePaths = new ArrayList<>();
        File file = new File(projectDir);


        if (file.isDirectory()) {
            File[] dirFiles = file.listFiles();
            System.out.println(dirFiles.toString());
            if (dirFiles.length == 0) return filePaths;
            for (File dirFile : dirFiles) {
                if (dirFile.isFile()) {
                    String relativePath = basePath + File.separator + dirFile.getName();
                    filePaths.add(relativePath);
                } else {
                    List<String> subDirFiles = getProjectFilesPath(dirFile.getAbsolutePath(), basePath + File.separator + dirFile.getName());
                    filePaths.addAll(subDirFiles);
                }
            }
        }
        return filePaths;
    }
}
