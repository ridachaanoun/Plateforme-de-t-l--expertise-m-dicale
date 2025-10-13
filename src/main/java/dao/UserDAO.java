package dao;

import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import utils.EntityManagerUtil;

import java.util.List;
import java.util.UUID;

public class UserDAO {
    // Create user
    public void save(User user) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Update user
    public void update(User user) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Delete user
    public void delete(UUID id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, id);
            if (user != null) em.remove(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Find by ID
    public User findById(UUID id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    //Find all
    public List<User> findAll() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            return em.createQuery("SELECT u FROM User u", User.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Find by username
    public User findByUsername(String username) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            TypedQuery<User> query = em.createQuery(
                    "SELECT u FROM User u WHERE u.username = :username", User.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    //Find by email
    public User findByEmail(String email) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            TypedQuery<User> query = em.createQuery(
                    "SELECT u FROM User u WHERE u.email = :email", User.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
