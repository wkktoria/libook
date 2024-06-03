<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MyBooks - List of Books</title>
    <link type="text/css" rel="stylesheet" href="stylesheet.css">
</head>
<body>
<div class="container">
    <header>
        <h1>MyBooks</h1>
    </header>
    <button class="btn add-btn" onclick="window.location.href='addBookForm.jsp';return false;">Add book</button>
    <table>
        <caption>List of books</caption>
        <thead>
        <tr>
            <th>Title</th>
            <th>Author</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.title}</td>
                <td>${book.author}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
