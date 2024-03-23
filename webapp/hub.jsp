<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AUCA Hub</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #00008B; 
            color: #fff;
            padding: 10px 20px;
            text-align: center;
            position: relative; /* Positioning context for absolute positioning */
        }

        nav {
            background-color: #f4f4f4;
            padding: 10px;
        }

        nav ul {
            list-style-type: none;
            padding: 0;
            text-align: center;
        }

        nav ul li {
            display: inline;
            margin-right: 20px;
        }

        nav ul li a {
            text-decoration: none;
            color: #fff; 
            background-color: #00008B; 
            padding: 10px 20px; 
            border-radius: 5px; 
        }

        /* Style for the last link */
        #home-link {
            background-color: #add8e6; /* Light blue color */
            padding: 8px 16px; /* Adjust padding to make it look like a button */
            border: none; /* Remove border */
            border-radius: 5px; /* Rounded corners */
            position: absolute; /* Positioning absolute */
            top: 50%; /* Position from the top */
            right: 20px; /* Position from the right */
            transform: translateY(-50%); /* Center vertically */
            color: #000; /* Black text color */
            text-decoration: none; /* Remove underline */
        }

        #home-link:hover {
            background-color: #87ceeb; /* Lighter shade of blue on hover */
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to AUCA Management system</h1>
        <a href="index.jsp" id="home-link">Go back to Home page</a>
    </header>
    <nav>
        <ul>
            <li><a href="studenthub.jsp">Students</a></li>
            <li><a href="#">Courses</a></li>
            <li><a href="#">Academic Unit</a></li>
            <li><a href="Semester.jsp">Semester</a></li>
            <li><a href="#">Teacher</a></li>
            <li><a href="#">Course Definition</a></li>
            <li><a href="#">Student Registration</a></li>
        </ul>
    </nav>
    <div class="content">
    </div>
</body>
</html>
