package by.home.webproject.service;

import by.home.webproject.dto.GenreDTO;
import by.home.webproject.dto.SingerDTO;
import by.home.webproject.dto.StatisticsDTO;
import by.home.webproject.dto.VoteDTO;
import by.home.webproject.service.api.IGenreService;
import by.home.webproject.service.api.ISingerService;
import by.home.webproject.service.api.IStatisticsService;
import by.home.webproject.service.api.IVoteService;
import by.home.webproject.service.fabrics.GenreServiceSingleton;
import by.home.webproject.service.fabrics.SingerServiceSingleton;
import by.home.webproject.service.fabrics.VoteServiceSingleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsServiceImpl implements IStatisticsService {

    private final Map<SingerDTO, Integer> singers;
    private final Map<GenreDTO, Integer> genres;
    private final List<String> texts;
    private final IGenreService genreService;
    private final ISingerService singerService;
    private final IVoteService voteService;

    public StatisticsServiceImpl() {
        singers = new HashMap<>();
        genres = new HashMap<>();
        texts = new ArrayList<>();
        singerService = SingerServiceSingleton.getInstance();
        genreService = GenreServiceSingleton.getInstance();
        voteService = VoteServiceSingleton.getInstance();
        initSingers();
        initGenres();
    }

    private void initSingers() {
        List<SingerDTO> singers = singerService.getAll();
        for (SingerDTO singer : singers) {
            this.singers.put(singer, 0);
        }
    }

    private void initGenres() {
        List<GenreDTO> genres = genreService.getAll();
        for (GenreDTO genre : genres) {
            this.genres.put(genre, 0);
        }
    }

//    private void updateActors(HttpServletRequest req) {
//        String actor = req.getParameter("actor");
//        singers.merge(actor, 1, (oldValue, newValue) -> oldValue + 1);
//    }
//
//    private void updateTexts(HttpServletRequest req) {
//        DateTimeFormatter formatter = DateTimeFormatter
//                .ofPattern("yyyy.MM.dd   HH:mm:ss:SSS");
//        String dateTimeNow = formatter.format(LocalDateTime.now());
//        texts.put(dateTimeNow, req.getParameter("text"));
//    }

    @Override
    public StatisticsDTO getStatistics() {
        List<VoteDTO> votes = voteService.getAll();
        return new StatisticsDTO(
                getSortedSingers(votes),
                getSortedGenres(votes),
                getSortedAboutYourself(votes)
        );
    }

    private String getSortedSingers(List<VoteDTO> votes) {
        votes.stream()
                .map(VoteDTO::getSinger)
                .map(singer -> singer[0])
                .forEach(singer -> singers.put(singer, singers.get(singer) + 1));
        return singers.entrySet()
                .stream()
                .sorted(Map.Entry.<SingerDTO, Integer>comparingByValue().reversed())
                .toString();
    }

    private String getSortedGenres(List<VoteDTO> votes) {
        votes.stream()
                .map(VoteDTO::getGenres)
                .flatMap(Arrays::stream)
                .forEach(genre -> genres.put(genre, genres.get(genre) + 1));
        return genres.entrySet()
                .stream()
                .sorted(Map.Entry.<GenreDTO, Integer>comparingByValue().reversed())
                .toString();
    }

    private String getSortedAboutYourself(List<VoteDTO> votes) {
        votes.stream()
                .map(vote -> vote.getVotingTime().toString() + vote.getAboutYourself()[0])
                .forEach(texts::add);
        return texts.stream()
                .sorted()
                .toString();
    }
}