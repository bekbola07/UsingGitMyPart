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

@WebServlet(value = "/add_order")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        Order order = Order.builder()
                .user(currentUser)
                .name(name)
                .build();
        new OrderRepo().save(order);
        resp.sendRedirect("/");

    }
}
