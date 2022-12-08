package by.home.webproject.service.fabrics;

import by.home.webproject.dao.fabrics.GenreDaoSingleton;
import by.home.webproject.service.GenreServiceImpl;

public class GenreServiceSingleton {

    private static volatile GenreServiceImpl instance;

    private GenreServiceSingleton() {

    }

    public static GenreServiceImpl getInstance() {
        GenreServiceImpl genreService = instance;
        if (genreService != null) {
            return genreService;
        }
        synchronized (GenreServiceSingleton.class) {
            if (instance == null) {
                instance = new GenreServiceImpl(GenreDaoSingleton.getInstance());
            }
        }
        return instance;
    }
}
