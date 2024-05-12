package org.example.usinggitmypart.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.example.usinggitmypart.entity.User;
import org.example.usinggitmypart.repo.UserRepo;

@WebListener
public class MyListener implements ServletContextListener {
    public static EntityManagerFactory emf;

    @Override
    public void contextInitialized(ServletContextEvent sce) {


        emf= Persistence.createEntityManagerFactory("punit");

        new UserRepo().save(
                User.builder()
                        .userName("admin")
                        .password("1234")
                        .build()
        );

        ServletContextListener.super.contextInitialized(sce);
    }
}
