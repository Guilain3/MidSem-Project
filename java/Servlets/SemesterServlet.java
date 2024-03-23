package Servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.time.LocalDate;
import Model.Semester;
import DAO.SemesterDAO;


@WebServlet(urlPatterns = {"semester"})
public class SemesterServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SemesterDAO semesterDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        semesterDAO = new SemesterDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action != null) {
            switch (action) {
                case "create":
                    createSemester(request, response);
                    break;
                case "update":
                    updateSemester(request, response);
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
                    deleteSemester(request, response);
                    break;
                default:
                    response.getWriter().println("Invalid action");
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        deleteSemester(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        updateSemester(request, response);
    }

    private void createSemester(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract parameters from request
        String semesterName = request.getParameter("semesterName");
        String startingDateStr = request.getParameter("startingDate");
        String endDateStr = request.getParameter("endDate");

        // Convert startingDate and endDate from String to LocalDate
        LocalDate startingDate = LocalDate.parse(startingDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        // Create Semester object
        Semester semester = new Semester(semesterName, startingDate, endDate, null);

        // Save Semester using DAO
        semesterDAO.save(semester);

        // Redirect or send response
        response.sendRedirect("index.jsp"); // Redirect to homepage or any other appropriate page
    }

    private void updateSemester(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract parameters from request
        int semId = Integer.parseInt(request.getParameter("semId"));
        String semesterName = request.getParameter("semesterName");
        String startingDateStr = request.getParameter("startingDate");
        String endDateStr = request.getParameter("endDate");

        // Convert startingDate and endDate from String to LocalDate
        LocalDate startingDate = LocalDate.parse(startingDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        // Create Semester object
        Semester semester = new Semester(semesterName, startingDate, endDate, null);
        semester.setId(semId); // Set ID

        // Update Semester using DAO
        semesterDAO.update(semester);

        // Redirect or send response
        response.sendRedirect("index.jsp"); // Redirect to homepage or any other appropriate page
    }


    private void deleteSemester(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int semId = Integer.parseInt(request.getParameter("semId"));

        // Fetch Semester using DAO
        Semester semester = semesterDAO.getSemesterById(semId);

        // Delete Semester using DAO
        semesterDAO.delete(semester);

        // Redirect or send response
        response.sendRedirect("index.jsp"); // Redirect to homepage or any other appropriate page
    }
}
