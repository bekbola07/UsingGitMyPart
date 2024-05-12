package org.example.usinggitmypart.serrvlets.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.usinggitmypart.entity.Order;
import org.example.usinggitmypart.entity.User;
import org.example.usinggitmypart.repo.OrderRepo;

import java.io.IOException;
import java.util.UUID;

@WebServlet(value = "/deleteOrder")
public class DeleteOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UUID id = UUID.fromString(req.getParameter("id"));
        Order order = new OrderRepo().getById(id);

        new OrderRepo().delete(id);
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        currentUser.getOrder().remove(order);


        resp.sendRedirect("/");
    }
}
