package by.home.webproject.controller.servlets;

import by.home.webproject.dto.StatisticsDTO;
import by.home.webproject.service.api.IStatisticsService;
import by.home.webproject.service.fabrics.StatisticsServiceSingleton;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResultServlet", urlPatterns = "/result")
public class ResultServlet extends HttpServlet {

    IStatisticsService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        service = StatisticsServiceSingleton.getInstance();
        StatisticsDTO statistics = service.getStatistics();
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(statistics.toString());
        }
    }
}