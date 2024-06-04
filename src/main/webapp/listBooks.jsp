<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>MyBooks - List of Books</title>
    <link type="text/css" rel="stylesheet" href="css/stylesheet.css">
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
            <c:url var="deleteLink" value="/books">
                <c:param name="command" value="delete"/>
                <c:param name="bookId" value="${book.id}"/>
            </c:url>

            <tr>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>
                    <div class="action-buttons">
                        <button class="btn update-btn" onclick="window.location.href='${bookLink}'">Update</button>
                        <button class="btn delete-btn"
                                onclick="if (confirm('Are you sure you want to delete this book?')) window.location.href='${deleteLink}'">
                            Delete
                        </button>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>Back to <a href="index.jsp">homepage</a>.</p>
</div>
</body>
</html>
