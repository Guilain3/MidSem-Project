package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.UserDao;
import Model.auca_user;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the GET request to the login page
        request.getRequestDispatcher("login.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("register")) {
            registerUser(request, response);
        } else {
            loginUser(request, response);
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        auca_user newUser = new auca_user();
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setRole(role);

        userDao.saveUser(newUser);

        // Redirect to login page after registration
        response.sendRedirect("login.html");
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        auca_user user = userDao.getUser(email, password, role);

        if (user != null) {
            // Create session
            HttpSession httpSession = request.getSession(true);

            // Store user object in the session for future reference
            httpSession.setAttribute("user", user);
            
            // Store timestamp of the last interaction in the session
            httpSession.setAttribute("lastInteractionTime", System.currentTimeMillis());

            // Redirect to home page
            response.sendRedirect("index.jsp");
        } else {
            // Authentication failed, redirect back to login page with an error message
            response.sendRedirect("login.html?error=1");
        }
    }

}
