package by.home.webproject.service.fabrics;

import by.home.webproject.service.StatisticsServiceImpl;

public class StatisticsServiceSingleton {

    private static volatile StatisticsServiceImpl instance;

    private StatisticsServiceSingleton() {

    }

    public static StatisticsServiceImpl getInstance() {
        StatisticsServiceImpl statisticsService = instance;
        if (statisticsService != null) {
            return statisticsService;
        }
        synchronized (StatisticsServiceSingleton.class) {
            if (instance == null) {
                instance = new StatisticsServiceImpl();
            }
        }
        return instance;
    }
}
