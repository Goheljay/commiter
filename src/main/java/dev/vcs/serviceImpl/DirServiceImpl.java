package dev.vcs.serviceImpl;

import dev.vcs.service.DirService;

import java.io.File;

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
}
