package by.home.webproject.dao.api;

import by.home.webproject.dto.SingerDTO;

import java.util.List;

public interface ISingerDao {

    List<SingerDTO> getAll();
}