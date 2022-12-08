package by.home.webproject.dao.fabrics;

import by.home.webproject.dao.SingerDaoImpl;

public class SingerDaoSingleton {

    private static volatile SingerDaoImpl instance;

    private SingerDaoSingleton() {

    }

    public static SingerDaoImpl getInstance() {
        SingerDaoImpl singerDao = instance;
        if (singerDao != null) {
            return singerDao;
        }
        synchronized (SingerDaoSingleton.class) {
            if (instance == null) {
                instance = new SingerDaoImpl();
            }
        }
        return instance;
    }
}
