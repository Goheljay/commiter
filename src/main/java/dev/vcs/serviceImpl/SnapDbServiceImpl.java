package dev.vcs.serviceImpl;

import dev.vcs.service.SnapDbService;

import java.io.File;
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
    public void addFirstFlowOfFiles(String path) {
        getProjectFileSnapshot(path);
    }
    private List<String> getProjectFileSnapshot(String path) {
        List<String> filePaths = getProjectFilesPath(path);
        List<String> unwantedPaths = new ArrayList<>();
        filePaths.forEach(s -> {
            if (s.contains("\\" + "./commiter")) {
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
