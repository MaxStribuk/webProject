package by.home.webproject.dao;

import by.home.webproject.dao.api.IGenreDao;
import by.home.webproject.dto.GenreDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenreDaoImpl implements IGenreDao {

    private final List<GenreDTO> genres;

    public GenreDaoImpl() {
        genres = new ArrayList<>();
        initGenres();
    }

    private void initGenres() {
        Collections.addAll(genres,
                new GenreDTO("metal"),
                new GenreDTO("country"),
                new GenreDTO("blues"),
                new GenreDTO("pop"),
                new GenreDTO("rock"),
                new GenreDTO("rap"),
                new GenreDTO("dance"),
                new GenreDTO("indie"),
                new GenreDTO("classical"),
                new GenreDTO("jazz"));
    }

    @Override
    public List<GenreDTO> getAll() {
        return Collections.unmodifiableList(genres);
    }
}