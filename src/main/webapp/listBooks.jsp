<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, io.github.wkktoria.mybooks.*" %>
<html>
<head>
    <title>MyBooks - List of Books</title>
    <link type="text/css" rel="stylesheet" href="stylesheet.css">
</head>
<body>
<%
    List<Book> books = (List<Book>) request.getAttribute("books");
%>

<div class="container">
    <header>
        <h1>MyBooks</h1>
    </header>
    <table>
        <caption>List of books</caption>
        <thead>
        <tr>
            <th>Title</th>
            <th>Author</th>
        </tr>
        </thead>
        <tbody>
        <% for (Book book : books) {%>
        <tr>
            <td><%= book.getTitle()%>
            </td>
            <td><%= book.getAuthor()%>
            </td>
        </tr>
        <% }%>
        </tbody>
    </table>
</div>
</body>
</html>
