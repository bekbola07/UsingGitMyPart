package org.example.usinggitmypart.serrvlets.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.usinggitmypart.entity.Order;
import org.example.usinggitmypart.entity.OrderStatus;
import org.example.usinggitmypart.entity.User;
import org.example.usinggitmypart.repo.OrderRepo;

import java.io.IOException;
import java.util.UUID;

@WebServlet(value = "/updateOrder")
public class EditOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UUID orderId = UUID.fromString(req.getParameter("id"));
        String name=req.getParameter("name");
        String status=req.getParameter("status");
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");


        Order order= new Order();
       order.setId(orderId);
       order.setOrderStatus(OrderStatus.valueOf(status));
       order.setName(name);
        currentUser.getOrder().remove(new OrderRepo().getById(orderId));
       currentUser.getOrder().add(order);
        new OrderRepo().update(order);
        resp.sendRedirect("/");


    }
}
