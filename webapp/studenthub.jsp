<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h2 {
            margin-top: 0;
        }

        label {
            font-weight: bold;
        }

        input[type="text"],
        input[type="date"],
        input[type="number"] {
            width: calc(100% - 22px);
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #007bff; /* Blue color */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3; /* Darker blue color on hover */
        }

        /* Better-looking button design */
        .btn {
            display: inline-block;
            padding: 10px 20px;
            border-radius: 5px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            transition: background-color 0.3s ease;
            border: 2px solid #007bff;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }

        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }

        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }

        /* Message display */
        #successMessage,
        #errorMessage {
            display: none;
            margin-top: 10px;
            padding: 10px;
            border-radius: 4px;
            text-align: center;
        }

        #successMessage {
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }

        #errorMessage {
            background-color: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Student Management</h2>

    <!-- Form for registering a new student -->
    <h2>Register Student</h2>
    <form action="student?action=create" method="post">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required><br>
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br>
        <label for="dateOfBirth">Date of Birth:</label>
        <input type="date" id="dateOfBirth" name="dateOfBirth" required><br>
        <input type="submit" value="Create Student">
    </form>

    <!-- Form for updating a student -->
    <h2>Update Student</h2>
    <form action="student?action=update" method="post">
        <label for="updateStudentId">Student ID:</label>
        <input type="number" id="updateStudentId" name="studentId" required><br>
        <label for="updateFirstName">First Name:</label>
        <input type="text" id="updateFirstName" name="firstName" required><br>
        <label for="updateLastName">Last Name:</label>
        <input type="text" id="updateLastName" name="lastName" required><br>
        <label for="updateDateOfBirth">Date of Birth:</label>
        <input type="date" id="updateDateOfBirth" name="dateOfBirth" required><br>
        <input type="submit" value="Update Student">
    </form>

    <!-- Form for deleting a student -->
    <h2>Delete Student</h2>
    <form action="student" method="get">
            <input type="hidden" name="action" value="delete"> 
        <label for="deleteStudentId">Student ID:</label>
        <input type="number" id="deleteStudentId" name="studentId" required><br>
        <input type="submit" value="Delete Student">
    </form>

    <!-- Success and error messages -->
    <div id="successMessage"></div>
    <div id="errorMessage"></div>
</div>

<script>
    function showSuccessMessage(message) {
        var successMessage = document.getElementById("successMessage");
        successMessage.style.display = "block";
        successMessage.innerHTML = message;
        setTimeout(function() {
            successMessage.style.display = "none";
        }, 3000);
    }

    function showErrorMessage(message) {
        var errorMessage = document.getElementById("errorMessage");
        errorMessage.style.display = "block";
        errorMessage.innerHTML = message;
        setTimeout(function() {
            errorMessage.style.display = "none";
        }, 3000);
    }
</script>

</body>
</html>
