<%@page import="Model.Semester"%>
<%@page import="java.util.List"%>
<%@page import="DAO.SemesterDAO"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Course Actions</title>
    <style>
    /* CSS styles for forms */
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }

    .form-container {
        width: 80%; /* Adjusted width */
        max-width: 600px; /* Limiting maximum width for better readability */
        padding: 20px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
    }

    label {
        display: block;
        font-weight: bold;
        margin-bottom: 8px; /* Adjusted margin */
    }

    input[type="text"],
    select {
        width: calc(100% - 16px); /* Adjusted width to accommodate border */
        padding: 8px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type="submit"],
    input[type="button"] {
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
        margin-top: 10px;
    }

    input[type="submit"]:hover,
    input[type="button"]:hover {
        filter: brightness(90%); /* Adjusted hover effect */
    }

    input[type="submit"] {
        margin-right: 10px;
    }

    input[type="button"] {
        background-color: #dc3545;
    }

    input[type="button"]:hover {
        filter: brightness(90%);
    }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Course Management</h2>

    <!-- Create Course Form -->
    <form id="createForm" method="post" action="courses">
        <input type="hidden" name="action" value="create">
        <label for="courseCode">Course Code:</label>
        <input type="text" id="courseCode" name="courseCode" required><br>
        <label for="courseName">Course Name:</label>
        <input type="text" id="courseName" name="courseName" required><br>
        <label for="semesterId">Semester:</label>
        <select id="semesterId" name="semesterId" required>
            <%-- Populate semester options dynamically --%>
            <% 
                SemesterDAO semesterDAO = new SemesterDAO();
                List<Semester> semesters = semesterDAO.getAllSemesters();
                for (Semester semester : semesters) {
            %>
                <option value="<%= semester.getId() %>"><%= semester.getSemesterName() %></option>
            <% } %>
        </select><br>
        <label for="department">Department:</label>
        <select id="department" name="department" required>
            <option value="Programme">Software Engineering</option>
            <option value="Faculty">Networking</option>
            <option value="Department">Information Management</option>
        </select><br>
        <input type="submit" value="Save">
    </form>

    <!-- Update Course Form -->
    <form id="updateForm" method="post" action="courses">
        <input type="hidden" name="action" value="update">
        <input type="hidden" id="updateCourseId" name="id">
        <label for="updateCourseCode">Course Code:</label>
        <input type="text" id="updateCourseCode" name="courseCode" required><br>
        <label for="updateCourseName">Course Name:</label>
        <input type="text" id="updateCourseName" name="courseName" required><br>
        <label for="updateSemesterId">Semester:</label>
        <select id="updateSemesterId" name="semesterId" required>
            <%-- Populate semester options dynamically --%>
            <% 
                List<Semester> semesters2 = semesterDAO.getAllSemesters();
                for (Semester semester : semesters) {
            %>
                <option value="<%= semester.getId() %>"><%= semester.getSemesterName() %></option>
            <% } %>
        </select><br>
        <label for="updateDepartment">Department:</label>
        <select id="updateDepartment" name="department" required>
            <option value="Programme">Software Engineering</option>
            <option value="Faculty">Networking</option>
            <option value="Department">Information Management</option>
        </select><br>
        <input type="submit" value="Update">
    </form>

    <!-- Delete Course Form -->
<form id="deleteForm" action="courses" method="post" onsubmit="submitForm(event)">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="_method" value="DELETE">
    <label for="deleteCourseId">Enter Course ID to Delete:</label>
    <input type="text" id="deleteCourseId" name="courseId" required><br>
    <input type="submit" value="Delete">
</form>

</div>

</body>
</html>
