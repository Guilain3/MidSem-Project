<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Semester Management</title>
    <style>
        /* Basic CSS for styling */
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
        input[type="date"] {
            width: 100%;
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
        }

        input[type="submit"]:hover {
            background-color: #0056b3; /* Darker blue color on hover */
        }

        .delete-form {
            margin-top: 20px;
            border-top: 1px solid #ccc;
            padding-top: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Semester Management</h2>
    <form action="semester" method="post">
        <input type="hidden" name="action" value="create"> <!-- Hidden field to specify action -->
        <label for="semesterName">Semester Name:</label>
        <input type="text" id="semesterName" name="semesterName" required>
        <label for="startingDate">Starting Date:</label>
        <input type="date" id="startingDate" name="startingDate" required>
        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate" required>
        <input type="submit" value="Create Semester">
    </form>

    <!-- Form for updating a semester -->
    <h2>Update Semester</h2>
    <form action="semester" method="post">
        <input type="hidden" name="action" value="update"> <!-- Hidden field to specify action -->
        <label for="semId">Semester ID:</label>
        <input type="text" id="semId" name="semId" required>
        <label for="semesterNameUpdate">New Semester Name:</label>
        <input type="text" id="semesterNameUpdate" name="semesterName" required>
        <label for="startingDateUpdate">New Starting Date:</label>
        <input type="date" id="startingDateUpdate" name="startingDate" required>
        <label for="endDateUpdate">New End Date:</label>
        <input type="date" id="endDateUpdate" name="endDate" required>
        <input type="submit" value="Update Semester">
    </form>

    <!-- Form for deleting a semester -->
    <div class="delete-form">
        <h2>Delete Semester</h2>
        <form action="semester" method="get">
            <input type="hidden" name="action" value="delete"> <!-- Hidden field to specify action -->
            <label for="semIdDelete">Semester ID:</label>
            <input type="text" id="semIdDelete" name="semId" required>
            <input type="submit" value="Delete Semester">
        </form>
    </div>
</div>

</body>
</html>
