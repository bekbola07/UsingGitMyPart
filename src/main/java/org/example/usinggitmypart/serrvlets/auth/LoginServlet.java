package org.example.usinggitmypart.serrvlets.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.usinggitmypart.entity.User;
import org.example.usinggitmypart.repo.UserRepo;

import java.io.IOException;

@WebServlet(value = "/auth/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepo userRepo = new UserRepo();

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user=userRepo.checkByLoginPassword(login,password);
        if (user==null){

            resp.sendRedirect("/login.jsp");
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("currentUser",user);
        resp.sendRedirect("/");

    }
}
