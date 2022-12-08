package by.home.webproject.dao;

import by.home.webproject.dao.api.ISingerDao;
import by.home.webproject.dto.SingerDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingerDaoImpl implements ISingerDao {

    private final List<SingerDTO> singers;

    public SingerDaoImpl() {
        singers = new ArrayList<>();
        initSingers();
    }

    private void initSingers() {
        Collections.addAll(singers,
                new SingerDTO("Freddie Mercury"),
                new SingerDTO("John Lennon"),
                new SingerDTO("Bob Marley"),
                new SingerDTO("Paul McCartney"));
    }

    @Override
    public List<SingerDTO> getAll() {
        return Collections.unmodifiableList(singers);
    }
}