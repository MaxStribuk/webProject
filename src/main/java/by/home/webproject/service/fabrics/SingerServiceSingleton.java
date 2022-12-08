package by.home.webproject.service.fabrics;

import by.home.webproject.dao.fabrics.SingerDaoSingleton;
import by.home.webproject.service.SingerServiceImpl;

public class SingerServiceSingleton {

    private static volatile SingerServiceImpl instance;

    private SingerServiceSingleton() {

    }

    public static SingerServiceImpl getInstance() {
        SingerServiceImpl singerService = instance;
        if (singerService != null) {
            return singerService;
        }
        synchronized (SingerServiceSingleton.class) {
            if (instance == null) {
                instance = new SingerServiceImpl(SingerDaoSingleton.getInstance());
            }
        }
        return instance;
    }
}
