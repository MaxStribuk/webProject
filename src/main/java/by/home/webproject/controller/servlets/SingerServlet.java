package by.home.webproject.controller.servlets;

import by.home.webproject.dto.SingerDTO;
import by.home.webproject.service.api.ISingerService;
import by.home.webproject.service.fabrics.SingerServiceSingleton;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "SingerServlet", urlPatterns = "/nomination/singer")
public class SingerServlet extends HttpServlet {

    ISingerService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        service = SingerServiceSingleton.getInstance();
        List<SingerDTO> singers = service.getAll();
        try (PrintWriter writer = resp.getWriter()) {
            String singersList = singers.stream()
                    .map(SingerDTO::toString)
                    .collect(Collectors.joining("\n"));
            writer.write(singersList);
        }
    }
}