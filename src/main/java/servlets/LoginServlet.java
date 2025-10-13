package servlets;

import entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import services.AuthService;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final AuthService authService = new AuthService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ Check if user is already logged in
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");

            // Redirect user to their dashboard
            switch (user.getRole()) {
                case GENERALIST:
                    response.sendRedirect("dashboard-generalist");
                    return;
                case SPECIALIST:
                    response.sendRedirect("dashboard-specialist");
                    return;
                case NURSE:
                    response.sendRedirect("dashboard-nurse");
                    return;
            }
        }

        // If not logged in, show login page
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = authService.login(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(30 * 60); // 30 min session timeout

            // Redirect based on role
            switch (user.getRole()) {
                case GENERALIST:
                    response.sendRedirect("dashboard-generalist");
                    break;
                case SPECIALIST:
                    response.sendRedirect("dashboard-specialist");
                    break;
                case NURSE:
                    response.sendRedirect("dashboard-nurse");
                    break;
                default:
                    response.sendRedirect("login?error=role");
                    break;
            }

        } else {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        }
    }
}
