package by.home.webproject.controller.servlets;

import by.home.webproject.dto.GenreDTO;
import by.home.webproject.dto.SingerDTO;
import by.home.webproject.dto.VoteDTO;
import by.home.webproject.service.api.IVoteService;
import by.home.webproject.service.fabrics.VoteServiceSingleton;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

@WebServlet(name = "VoteServlet", urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {

    private final String SINGER = "singer";
    private final String GENRE = "genre";
    private final String ABOUT_YOURSELF = "aboutYourself";
    IVoteService service;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        service = VoteServiceSingleton.getInstance();
        try {
            VoteDTO vote = createVote(req);
            service.save(vote);
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/result");
        } catch (NullPointerException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private VoteDTO createVote(HttpServletRequest req)
            throws NullPointerException {
        String[] singers = req.getParameterValues(SINGER);
        String[] genres = req.getParameterValues(GENRE);
        LocalDateTime votingTime = LocalDateTime.now();
        String[] aboutYourself = req.getParameterValues(ABOUT_YOURSELF);
        SingerDTO[] singerDTOS = Arrays.stream(singers)
                .map(SingerDTO::new)
                .toArray(SingerDTO[]::new);
        GenreDTO[] genreDTOS = Arrays.stream(genres)
                .map(GenreDTO::new)
                .toArray(GenreDTO[]::new);
        return new VoteDTO(
                singerDTOS, genreDTOS, votingTime, aboutYourself);
    }
}