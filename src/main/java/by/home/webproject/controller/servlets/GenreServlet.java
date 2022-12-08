package by.home.webproject.controller.servlets;

import by.home.webproject.dto.GenreDTO;
import by.home.webproject.service.api.IGenreService;
import by.home.webproject.service.fabrics.GenreServiceSingleton;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "GenreServlet", urlPatterns = "/nomination/genre")
public class GenreServlet extends HttpServlet {

    private final IGenreService service = GenreServiceSingleton.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        List<GenreDTO> genres = service.getAll();
        try (PrintWriter writer = resp.getWriter()) {
            String genresList = genres.stream()
                    .map(GenreDTO::toString)
                    .collect(Collectors.joining("\n"));
            writer.write(genresList);
        }
    }
}