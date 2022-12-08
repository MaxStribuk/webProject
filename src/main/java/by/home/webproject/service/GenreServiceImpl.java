package by.home.webproject.service;

import by.home.webproject.dao.api.IGenreDao;
import by.home.webproject.dto.GenreDTO;
import by.home.webproject.service.api.IGenreService;

import java.util.List;

public class GenreServiceImpl implements IGenreService {

    IGenreDao dao;

    public GenreServiceImpl(IGenreDao dao) {
        this.dao = dao;
    }

    @Override
    public List<GenreDTO> getAll() {
        return dao.getAll();
    }
}
