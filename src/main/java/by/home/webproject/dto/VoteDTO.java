package by.home.webproject.dto;

import java.time.LocalDateTime;

public class VoteDTO {

    private final SingerDTO[] singer;
    private final GenreDTO[] genres;
    private final LocalDateTime votingTime;
    private final String[] aboutYourself;

    public VoteDTO(SingerDTO[] singer, GenreDTO[] genres,
                   LocalDateTime votingTime, String[] aboutYourself) {
        this.singer = singer;
        this.genres = genres;
        this.votingTime = votingTime;
        this.aboutYourself = aboutYourself;
    }

    public SingerDTO[] getSinger() {
        return singer;
    }

    public GenreDTO[] getGenres() {
        return genres;
    }

    public LocalDateTime getVotingTime() {
        return votingTime;
    }

    public String[] getAboutYourself() {
        return aboutYourself;
    }
}