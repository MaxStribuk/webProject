package by.home.webproject.dto;

public class StatisticsDTO {

    private final String bestSingers;
    private final String bestGenres;
    private final String aboutYourself;

    public StatisticsDTO(String bestSingers, String bestGenres, String aboutYourself) {
        this.bestSingers = bestSingers;
        this.bestGenres = bestGenres;
        this.aboutYourself = aboutYourself;
    }

    @Override
    public String toString() {
        return "Лучшие исполнители:\n" +
                bestSingers +
                "Наиболее популярные жанры:\n" +
                bestGenres +
                "Информациия о голосовавших:\n" +
                aboutYourself;
    }
}