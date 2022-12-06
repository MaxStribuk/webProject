package by.home.webproject.servlets;

import by.home.webproject.dao.Dao;
import by.home.webproject.dao.DataDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GenreServlet", urlPatterns = "/nomination/genre")
public class GenreServlet extends HttpServlet {

    Dao dao = new DataDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(dao.getData("src/main/resources/Genres.txt"));
        }
    }
}
