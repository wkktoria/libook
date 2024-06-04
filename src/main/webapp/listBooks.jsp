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
    <button class="btn add-btn" onclick="window.location.href='addBookForm.jsp'">Add book</button>
    <table>
        <caption>List of books</caption>
        <thead>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <c:url var="bookLink" value="/books">
                <c:param name="command" value="load"/>
                <c:param name="bookId" value="${book.id}"/>
            </c:url>

            <tr>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>
                    <button class="btn update-btn" onclick="window.location.href='${bookLink}'">Update</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
