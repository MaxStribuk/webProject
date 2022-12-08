package by.home.webproject.dao.fabrics;

import by.home.webproject.dao.VotingDaoImpl;

public class VotingDaoSingleton {

    private static volatile VotingDaoImpl instance;

    private VotingDaoSingleton() {

    }

    public static VotingDaoImpl getInstance() {
        VotingDaoImpl votingDao = instance;
        if (votingDao != null) {
            return votingDao;
        }
        synchronized (VotingDaoSingleton.class) {
            if (instance == null) {
                instance = new VotingDaoImpl();
            }
        }
        return instance;
    }
}
