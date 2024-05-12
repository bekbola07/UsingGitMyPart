package org.example.usinggitmypart.serrvlets.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.usinggitmypart.repo.UserRepo;

import java.io.IOException;
import java.util.UUID;

@WebServlet(value = "/auth/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UUID userId = UUID.fromString(req.getParameter("userId"));
        UserRepo userRepo = new UserRepo();
        userRepo.delete(userId);
        resp.sendRedirect("/admin/admin_menu.jsp");

    }
}
