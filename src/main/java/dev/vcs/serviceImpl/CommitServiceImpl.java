package dev.vcs.serviceImpl;

import dev.vcs.service.CommitService;

public class CommitServiceImpl implements CommitService {
    private static CommitServiceImpl  obj = null;

    public CommitServiceImpl getInstance() {
        if (obj == null){
            obj = new CommitServiceImpl();
        }
        return obj;
    }
}
