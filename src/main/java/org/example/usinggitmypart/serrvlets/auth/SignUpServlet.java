package org.example.usinggitmypart.serrvlets.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.usinggitmypart.entity.User;
import org.example.usinggitmypart.repo.UserRepo;

import java.io.IOException;


@WebServlet(value = "/auth/signup")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String password1 = req.getParameter("password1");

        User user = User.builder()
                .userName(username)
                .password(password1)
                .build();


        User currentUser= new UserRepo().save(user);
        System.out.println(currentUser);

        session.setAttribute("currentUser",currentUser);

        resp.sendRedirect("/");
    }

}
