<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    <form action="${pageContext.request.contextPath}/books" method="get">
        <input type="hidden" name="command" value="search">

        <label for="search">Search book:</label>
        <input id="search" type="text" name="searchValue" placeholder="Enter a title or an author..."/>

        <button class="btn search-btn" type="submit">Search</button>
    </form>
    <table>
        <caption>List of books</caption>
        <thead>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Status</th>
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
                <c:set var="status" value="${fn:toLowerCase(fn:join(fn:split(book.status, '_'), ' '))}"/>
                <td>${status}</td>
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
