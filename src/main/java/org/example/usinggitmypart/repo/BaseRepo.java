package org.example.usinggitmypart.repo;

import jakarta.persistence.EntityManager;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

import static org.example.usinggitmypart.config.MyListener.emf;

public class BaseRepo <T>{
    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public BaseRepo() {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof ParameterizedType) {
            Type[] typeArgs = ((ParameterizedType) superClass).getActualTypeArguments();
            entityClass = (Class<T>) typeArgs[0];
        }
    }
    public T save(T t){
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
            return t;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
    public T getById(UUID id){
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(entityClass, id);
    }
    public List<T> getAll(){
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.createQuery("select t from "+entityClass.getSimpleName()+" t",entityClass).getResultList();
    }
    public void delete(UUID id){
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            T t = entityManager.find(entityClass, id);
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }
    public void update(T t){
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

}
