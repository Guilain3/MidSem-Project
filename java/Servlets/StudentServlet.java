package Servlets;

import DAO.StudentDAO;
import Model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "save":
                save(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String dobString = request.getParameter("dateOfBirth");
        LocalDate dob = LocalDate.parse(dobString); // Parse String to LocalDate
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        Student student = new Student(firstName, lastName, dob);
        studentDAO.save(student);

        response.sendRedirect(request.getContextPath() + "/Student.jsp");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId")); // Assuming you have a parameter named "studentId" in your request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dobString = request.getParameter("dateOfBirth");
        LocalDate dob = LocalDate.parse(dobString); // Parse String to LocalDate

        Student student = new Student();
        student.setId(studentId); // Set studentId using setId method
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setDateOfBirth(dob);
        studentDAO.update(student);

        response.sendRedirect(request.getContextPath() + "/Success.jsp");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId")); // Assuming you have a parameter named "studentId" in your request

        Student student = new Student();
        student.setId(studentId); // Set studentId using setId method
        studentDAO.delete(student);

        response.sendRedirect(request.getContextPath() + "/Success.jsp");
    }
}
