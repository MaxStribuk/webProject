package by.home.webproject.repository;

import by.home.webproject.dao.Dao;
import by.home.webproject.dao.DataDao;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class VoiceRepositoryImpl implements VoiceRepository {

    private final Map<String, Integer> actors;
    private final Map<String, Integer> genres;
    private final Map<String, String> texts;
    private final Dao dao = new DataDao();

    public VoiceRepositoryImpl() {
        actors = new HashMap<>();
        genres = new HashMap<>();
        texts = new HashMap<>();
        initMap("src/main/resources/Actors.txt", actors);
        initMap("src/main/resources/Genres.txt", genres);
    }

    @Override
    public boolean vote(HttpServletRequest req) {
        boolean isCorrectVoice = checkCorrectnessVoice(req);
        if (isCorrectVoice) {
            updateActors(req);
            updateGenres(req);
            updateTexts(req);
            return true;
        } else {
            return false;
        }
    }

    private void initMap(String URL, Map<String, Integer> dataMap) {
        try {
            String lines = dao.getData(URL);
            Arrays.stream(lines.split("\n"))
                    .forEach(line -> dataMap.put(line, 0));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean checkCorrectnessVoice(HttpServletRequest req) {
        String[] genres = req.getParameterValues("genre");
        if (genres == null || genres.length < 3 || genres.length > 5) {
            return false;
        }
        String[] actors = req.getParameterValues("actor");
        if (actors == null || actors.length > 1) {
            return false;
        }
        return true;
    }

    private void updateActors(HttpServletRequest req) {
        String actor = req.getParameter("actor");
        actors.merge(actor, 1, (oldValue, newValue) -> oldValue + 1);
    }

    private void updateGenres(HttpServletRequest req) {
        String[] genres = req.getParameterValues("genre");
        Arrays.stream(genres)
                .forEach(genre -> this.genres.merge(
                        genre, 1, (oldValue, newValue) -> oldValue + 1));
    }

    private void updateTexts(HttpServletRequest req) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy.MM.dd   HH:mm:ss:SSS");
        String dateTimeNow = formatter.format(LocalDateTime.now());
        texts.put(dateTimeNow, req.getParameter("text"));
    }

    @Override
    public Map<String, Integer> getActors() {
        return actors;
    }

    @Override
    public Map<String, Integer> getGenres() {
        return genres;
    }

    @Override
    public Map<String, String> getTexts() {
        return texts;
    }
}
