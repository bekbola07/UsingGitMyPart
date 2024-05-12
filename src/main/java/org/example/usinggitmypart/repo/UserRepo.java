package org.example.usinggitmypart.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.usinggitmypart.entity.User;

import static org.example.usinggitmypart.config.MyListener.emf;

public class UserRepo extends BaseRepo<User>{

    public User checkByLoginPassword(String userName, String password) {

        EntityManager entityManager = emf.createEntityManager();
        try {
            String jpql = "SELECT u FROM User u WHERE u.userName = :login AND u.password = :password";
            TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
            query.setParameter("login", userName);
            query.setParameter("password", password);
            return query.getSingleResult(); // limit 1
        } catch (NoResultException e) {
            return null;
        }
    }

}
