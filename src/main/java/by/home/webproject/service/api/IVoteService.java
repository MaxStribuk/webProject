package by.home.webproject.service.api;

import by.home.webproject.dto.VoteDTO;

import java.util.List;

public interface IVoteService {

    boolean validate(VoteDTO vote);
    void save(VoteDTO vote) throws IllegalArgumentException;
    List<VoteDTO> getAll();
}