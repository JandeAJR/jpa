package com.udemy.application.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import com.udemy.infrastructure.models.Request;
import com.udemy.infrastructure.utils.EntityManagerFactorySingleton;

/*
	Esta classe representa os serviços disponíveis para o pedido.
*/

public class RequestService {
	EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Request requestRegistration(Request request) {
        entityManager.getTransaction().begin();
        entityManager.persist(request);
        entityManager.getTransaction().commit();
        return request;
    }

    public Request findById(Long id) {
        return entityManager.find(Request.class, id);
    }

    public List<Request> findAll() {
    	TypedQuery<Request> query = entityManager.createQuery("from Request", Request.class);
        return query.getResultList();
    	
        //Query query = entityManager.createQuery("from Request");
        //return query.getResultList();
    }

    public Request update(Request request) {
        entityManager.getTransaction().begin();
        entityManager.persist(request);
        entityManager.getTransaction().commit();
        return request;
    }

    public void deleteById(Request request) {
        entityManager.getTransaction().begin();
        entityManager.remove(request);
        entityManager.getTransaction().commit();
    }

    public void closeEntityManager() {
        entityManager.close();
    }
}
