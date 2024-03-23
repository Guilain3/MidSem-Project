package Servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.time.LocalDate;
import Model.Student;
import DAO.StudentDAO;

@WebServlet(urlPatterns = {"/student"})
public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action != null) {
            switch (action) {
                case "create":
                    createStudent(request, response);
                    break;
                case "update":
                    updateStudent(request, response);
                    break;
                default:
                    response.getWriter().println("Invalid action");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action != null) {
            switch (action) {
                case "delete":
                    deleteStudent(request, response);
                    break;
                default:
                    response.getWriter().println("Invalid action");
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        deleteStudent(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        updateStudent(request, response);
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract parameters from request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dobString = request.getParameter("dateOfBirth");

        // Convert dob from String to LocalDate
        LocalDate dob = LocalDate.parse(dobString);

        // Create Student object
        Student student = new Student(firstName, lastName, dob);

        // Save Student using DAO
        studentDAO.save(student);

        // Redirect or send response
        response.sendRedirect("Success.jsp"); 
    }


    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract parameters from request
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dobString = request.getParameter("dateOfBirth");
        
        // Convert dobString to LocalDate
        LocalDate dob;
        try {
            dob = LocalDate.parse(dobString);
        } catch (Exception e) {
            // Show error message on the same page
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<div id=\"errorMessage\">Error: Invalid date format</div>");
            return;
        }

        // Create Student object
        Student student = new Student(firstName, lastName, dob);
        student.setId(studentId); // Set ID

        // Update Student using DAO
        studentDAO.update(student);

        // Redirect to success page
        response.sendRedirect("Success.jsp"); 
    }


    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));

        // Fetch Student using DAO
        Student student = studentDAO.getStudentById(studentId);

        // Delete Student using DAO
        studentDAO.delete(student);

        // Redirect to success page
        response.sendRedirect("Success.jsp"); 
    }
}
