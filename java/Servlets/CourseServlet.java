package Servlets;

import Model.AcademicUnitEnum;
import Model.Course;
import Model.Semester;
import DAO.CourseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/courses")
public class CourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CourseDAO courseDAO;

    public void init() {
        courseDAO = new CourseDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action parameter is missing");
            return;
        }

        switch (action) {
            case "edit": {
                // Fetch course details for editing
                int courseId = Integer.parseInt(request.getParameter("id"));
                Course course = courseDAO.getCourseById(courseId);
                if (course != null) {
                    request.setAttribute("course", course);
                    request.getRequestDispatcher("/edit-course.jsp").forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/courses?action=list");
                }
                break;
            }
            case "create": {
                // Show a form for creating a new course
                request.getRequestDispatcher("/create-course.jsp").forward(request, response);
                break;
            }
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests (creating data)
        String courseCode = request.getParameter("courseCode");
        String courseName = request.getParameter("courseName");
        String semesterIdString = request.getParameter("semesterId"); 
        String departmentString = request.getParameter("department");

        // Check if any of the parameters are null
        if (courseCode == null || courseName == null || semesterIdString == null || departmentString == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "One or more parameters are missing");
            return;
        }

        // Parse semesterId and handle NumberFormatException
        int semesterId;
        try {
            semesterId = Integer.parseInt(semesterIdString);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid semesterId");
            return;
        }

        // Parse department and handle IllegalArgumentException
        AcademicUnitEnum department;
        try {
            department = AcademicUnitEnum.valueOf(departmentString);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid department");
            return;
        }

        // Create semester object
        Semester semester = new Semester(); // You may fetch semester from database using semesterId
        semester.setId(semesterId);

        // Create course object
        Course course = new Course(courseCode, courseName, semester, department);
        courseDAO.save(course);
        response.sendRedirect(request.getContextPath() + "/Success.jsp"); // Redirect to Success.jsp after saving
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle PUT requests (updating data)
        int courseId = Integer.parseInt(request.getParameter("id"));
        Course existingCourse = courseDAO.getCourseById(courseId);

        if (existingCourse != null) {
            String courseCode = request.getParameter("courseCode");
            String courseName = request.getParameter("courseName");
            int semesterId = Integer.parseInt(request.getParameter("semesterId"));
            AcademicUnitEnum department = AcademicUnitEnum.valueOf(request.getParameter("department"));

            Semester semester = new Semester();
            semester.setId(semesterId);

            existingCourse.setCourseCode(courseCode);
            existingCourse.setCourseName(courseName);
            existingCourse.setSemester(semester);
            existingCourse.setDepartment(department);

            courseDAO.update(existingCourse);
            response.sendRedirect(request.getContextPath() + "/Success.jsp"); // Redirect to Success.jsp after updating
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle DELETE requests (deleting data)
        int courseId = Integer.parseInt(request.getParameter("course_id")); 
        Course course = courseDAO.getCourseById(courseId);
        if (course != null) {
            courseDAO.delete(course);
            response.sendRedirect(request.getContextPath() + "/Success.jsp"); 
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
    }
