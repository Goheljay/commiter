package dev.vcs.serviceImpl;

import com.google.gson.Gson;
import dev.vcs.entity.BranchModal;
import dev.vcs.service.BranchService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class BranchServiceImpl implements BranchService {
    private static BranchServiceImpl objBranchService = null;
    public static BranchServiceImpl getInstance() {
        if (objBranchService == null) {
            objBranchService = new BranchServiceImpl();
        }
        return objBranchService;
    }

    @Override
    public String createBranch(String path) throws IOException {
        StringBuilder rootDir = new StringBuilder();
        rootDir.append(path).append("/.commiter");
        File brnachFile = new File(rootDir.toString(),"BranchDB.json");
        if (!brnachFile.createNewFile()) {
            throw new RuntimeException("Failed to create branch File");
        }
        UUID branchId = UUID.randomUUID();
        BranchModal branchModal = new BranchModal();
        branchModal.setBranchName("master");
        branchModal.setId(branchId.toString());
        branchModal.setCreatedAt(new Date());
        String branchDetails = new Gson().toJson(branchModal);
        System.out.println("branchDetails ::: "+branchDetails);
        try (FileWriter fileWriter = new FileWriter(brnachFile)){
            fileWriter.write(branchDetails);
            return branchId.toString();
        }catch (IOException e) {
            throw new RuntimeException("FIle Not Created");
        }
    }
}
