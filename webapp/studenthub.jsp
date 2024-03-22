<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
            color: #333;
        }

        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        form {
            margin-bottom: 20px;
        }

        label, input, button {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="date"] {
            width: calc(100% - 20px);
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            cursor: pointer;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 8px 20px;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Student Management</h1>
        <form id="studentForm"  action="/student" method="post">

        <input type="hidden" name="studentId" id="studentId">
        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" id="firstName" required>
        <label for="lastName">Last Name:</label>
        <input type="text" name="lastName" id="lastName" required>
        <label for="dateOfBirth">Date of Birth:</label>
        <input type="date" name="dateOfBirth" id="dateOfBirth" required>
        <button type="submit" id="saveBtn">Save</button>
        <button type="button" id="updateBtn" style="display: none;">Update</button>
        <button type="button" id="deleteBtn" style="display: none;">Delete</button>
    </form>
    <table id="studentTable">
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of Birth</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <!-- Student data will be inserted here dynamically -->
        </tbody>
    </table>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        const studentForm = document.getElementById("studentForm");
        const saveBtn = document.getElementById("saveBtn");
        const updateBtn = document.getElementById("updateBtn");
        const deleteBtn = document.getElementById("deleteBtn");
        const studentTable = document.getElementById("studentTable");

        studentForm.addEventListener("submit", function (event) {
            event.preventDefault();
            const formData = new FormData(studentForm);
            const action = formData.get("action");
            fetch("/student?action=" + action, {
                method: "POST",
                body: formData
            })
            .then(response => response.text())
            .then(() => {
                location.reload();
            });
        });

        updateBtn.addEventListener("click", function () {
            document.getElementById("action").value = "update";
            studentForm.submit();
        });

        deleteBtn.addEventListener("click", function () {
            document.getElementById("action").value = "delete";
            studentForm.submit();
        });

        fetch("/student")
        .then(response => response.json())
        .then(students => {
            students.forEach(student => {
                const tr = document.createElement("tr");
                tr.innerHTML = `
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.dateOfBirth}</td>
                    <td>
                        <button type="button" onclick="editStudent('${student.studentId}', '${student.firstName}', '${student.lastName}', '${student.dateOfBirth}')">Edit</button>
                    </td>
                `;
                studentTable.querySelector("tbody").appendChild(tr);
            });
        });

        window.editStudent = function (id, firstName, lastName, dateOfBirth) {
            document.getElementById("studentId").value = id;
            document.getElementById("firstName").value = firstName;
            document.getElementById("lastName").value = lastName;
            document.getElementById("dateOfBirth").value = dateOfBirth;
            saveBtn.style.display = "none";
            updateBtn.style.display = "block";
            deleteBtn.style.display = "block";
        };
    });
</script>
</body>
</html>
