package servlet;

import entities.User;
import enums.ERole;
import utils.EntityManagerUtil; // Utility class to get EntityManager

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.persistence.EntityManager;

@WebServlet("/test")
public class TestDatabaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        EntityManager em = null;
        try {
            em = EntityManagerUtil.getEntityManager(); // get JPA EntityManager
            em.getTransaction().begin();
//            EntityManagerFactory emf = Persistence.createEntityManagerFactory("medicalPU");
//            EntityManager em = emf.createEntityManager();
//
//            em.getTransaction().begin();

            User user = new User();
            user.setFullName("Test User");
            user.setUsername("testuser");
            user.setEmail("test@gmail.com");
            user.setPassword("123456");
            user.setRole(ERole.NURSE);
            user.setCreatedAt(LocalDateTime.now());
            user.setUpdatedAt(LocalDateTime.now());

            em.persist(user);
            em.getTransaction().commit();

            em.close();

            out.println("<h2> Database connection successful!</h2>");
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            out.println("<h2> Database connection failed!</h2>");
            out.println("<pre>" + e.getMessage() + "</pre>");
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
