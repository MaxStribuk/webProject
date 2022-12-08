package by.home.webproject.service;

import by.home.webproject.dao.api.IVotingDao;
import by.home.webproject.dto.GenreDTO;
import by.home.webproject.dto.SingerDTO;
import by.home.webproject.dto.VoteDTO;
import by.home.webproject.service.api.IVoteService;

import java.util.List;

public class VoteServiceImpl implements IVoteService {

    IVotingDao dao;

    public VoteServiceImpl(IVotingDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean validate(VoteDTO vote) {
        return validateSingers(vote.getSinger())
                && validateGenres(vote.getGenres())
                && validateAboutYourself(vote.getAboutYourself());
    }

    @Override
    public void save(VoteDTO vote) throws IllegalArgumentException {
        boolean isValidVote = validate(vote);
        if (isValidVote) {
            dao.save(vote);
        } else {
            throw new IllegalArgumentException("Invalid vote ");
        }
    }

    @Override
    public List<VoteDTO> getAll() {
        return dao.getAll();
    }

    private boolean validateSingers(SingerDTO[] singers) {
        return singers != null
                && singers.length == 1;
    }

    private boolean validateGenres(GenreDTO[] genres) {
        return genres != null
                && genres.length >= 3
                && genres.length <= 5;
    }

    private boolean validateAboutYourself(String[] aboutYourself) {
        return aboutYourself != null
                && aboutYourself.length == 1;
    }
}