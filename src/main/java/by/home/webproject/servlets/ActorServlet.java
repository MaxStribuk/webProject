package by.home.webproject.servlets;

import by.home.webproject.dao.Dao;
import by.home.webproject.dao.DataDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ActorServlet", urlPatterns = "/nomination/actor")
public class ActorServlet extends HttpServlet {

    Dao dao = new DataDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String message = dao.getData("src/main/resources/Actors.txt");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(message);
        }
    }
}
