package com.udemy.application.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import com.udemy.infrastructure.models.Pizza;
import com.udemy.infrastructure.utils.EntityManagerFactorySingleton;

/*
	Esta classe representa os serviços disponíveis para o cadastro da pizza.
*/

public class PizzaService {
	EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Pizza pizzaRegistration(Pizza pizza) {
        entityManager.getTransaction().begin();
        entityManager.persist(pizza);
        entityManager.getTransaction().commit();
        return pizza;
    }

    public Pizza findById(Long id) {
        return entityManager.find(Pizza.class, id);
    }

    public List<Pizza> findAll() {
    	TypedQuery<Pizza> query = entityManager.createQuery("from Pizza", Pizza.class);
        return query.getResultList();
    	
        //Query query = entityManager.createQuery("from Pizza");
        //return query.getResultList();
    }

    public Pizza update(Pizza pizza) {
        entityManager.getTransaction().begin();
        entityManager.persist(pizza);
        entityManager.getTransaction().commit();
        return pizza;
    }

    public void deleteById(Pizza pizza) {
        entityManager.getTransaction().begin();
        entityManager.remove(pizza);
        entityManager.getTransaction().commit();
        //entityManager.getTransaction().rollback();
    }

    public void closeEntityManager() {
        entityManager.close();
    }
}
