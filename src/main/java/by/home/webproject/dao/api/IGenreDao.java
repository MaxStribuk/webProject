package by.home.webproject.dao.api;

import by.home.webproject.dto.GenreDTO;

import java.util.List;

public interface IGenreDao {

    List<GenreDTO> getAll();
}