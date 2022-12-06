package by.home.webproject.repository;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface VoiceRepository {

    boolean vote(HttpServletRequest req);

    Map<String, Integer> getActors();
    Map<String, Integer> getGenres();
    Map<String, String> getTexts();
}