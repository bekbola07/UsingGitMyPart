package org.example.usinggitmypart.serrvlets.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.usinggitmypart.repo.OrderRepo;

import java.io.IOException;
import java.util.UUID;

@WebServlet(value = "/deleteOrder")
public class DeleteOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        new OrderRepo().delete(UUID.fromString(req.getParameter("id")));

        resp.sendRedirect("/");
    }
}
