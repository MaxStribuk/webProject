package by.home.webproject.dao;

import by.home.webproject.dao.api.IVotingDao;
import by.home.webproject.dto.VoteDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VotingDaoImpl implements IVotingDao {

    private final List<VoteDTO> votes;

    public VotingDaoImpl() {
        votes = new ArrayList<>();
    }

    @Override
    public void save(VoteDTO vote) {
        votes.add(vote);
    }

    @Override
    public List<VoteDTO> getAll() {
        return Collections.unmodifiableList(votes);
    }
}