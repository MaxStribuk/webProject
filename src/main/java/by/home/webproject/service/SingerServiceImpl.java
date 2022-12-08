package by.home.webproject.service;

import by.home.webproject.dao.api.ISingerDao;
import by.home.webproject.dto.SingerDTO;
import by.home.webproject.service.api.ISingerService;

import java.util.List;

public class SingerServiceImpl implements ISingerService {

    ISingerDao dao;

    public SingerServiceImpl(ISingerDao dao) {
        this.dao = dao;
    }

    @Override
    public List<SingerDTO> getAll() {
        return dao.getAll();
    }
}