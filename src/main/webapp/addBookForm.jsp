<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Libook - Add Book</title>
    <link type="text/css" rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<div class="container">
    <header>
        <h1>Libook</h1>
    </header>
    <form action="${pageContext.request.contextPath}/books" method="post">
        <input type="hidden" name="command" value="add"/>

        <label for="title">Enter a title:</label>
        <input id="title" name="title" type="text" required/>

        <label for="author">Enter an author:</label>
        <input id="author" name="author" type="text" required/>

        <label for="status">Choose a status:</label>
        <select name="statusId" id="status">
            <option value="1">plan to read</option>
            <option value="2">currently reading</option>
            <option value="3">completed</option>
        </select>

        <button class="btn add-btn form-btn" type="submit">Add</button>
    </form>
    <p>Back to <a href="index.jsp">homepage</a>.</p>
</div>
</body>
</html>
