package by.home.webproject.dao.api;

import by.home.webproject.dto.VoteDTO;

import java.util.List;

public interface IVotingDao {

    void save(VoteDTO vote);
    List<VoteDTO> getAll();
}