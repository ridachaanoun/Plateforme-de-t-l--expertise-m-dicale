package servlet;

import utils.EntityManagerUtil; // Utility class to get EntityManager

import jakarta.servlet.ServletException;
// removed WebServlet annotation to avoid duplicate mapping (mapping is in web.xml)
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.persistence.EntityManager;

public class TestDatabaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        EntityManager em = null;
        try {
            em = EntityManagerUtil.getEntityManager(); // get JPA EntityManager
            em.getTransaction().begin();
            em.createNativeQuery("SELECT 1").getSingleResult(); // simple test query
            em.getTransaction().commit();

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
