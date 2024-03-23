<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 20px auto;
            text-align: center;
        }

        h1 {
            color: green;
        }

        p {
            font-size: 18px;
        }

        a {
            text-decoration: none;
            color: blue;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Success</h1>
    <p>Your operation was successful.</p>
    <a href="${pageContext.request.contextPath}/hub.jsp">Go back to Management Dashboard page</a>
</div>
</body>
</html>
