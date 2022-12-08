package by.home.webproject.dao.fabrics;

import by.home.webproject.dao.GenreDaoImpl;

public class GenreDaoSingleton {

    private static volatile GenreDaoImpl instance;

    private GenreDaoSingleton() {

    }

    public static GenreDaoImpl getInstance() {
        GenreDaoImpl genreDao = instance;
        if (genreDao != null) {
            return genreDao;
        }
        synchronized (GenreDaoSingleton.class) {
            if (instance == null) {
                instance = new GenreDaoImpl();
            }
        }
        return instance;
    }
}
