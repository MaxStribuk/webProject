package by.home.webproject.service.fabrics;

import by.home.webproject.dao.fabrics.VotingDaoSingleton;
import by.home.webproject.service.VoteServiceImpl;

public class VoteServiceSingleton {

    private static volatile VoteServiceImpl instance;

    private VoteServiceSingleton() {

    }

    public static VoteServiceImpl getInstance() {
        VoteServiceImpl voteService = instance;
        if (voteService != null) {
            return voteService;
        }
        synchronized (VoteServiceSingleton.class) {
            if (instance == null) {
                instance = new VoteServiceImpl(VotingDaoSingleton.getInstance());
            }
        }
        return instance;
    }
}