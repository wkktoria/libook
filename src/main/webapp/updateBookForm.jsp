<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>MyBooks - Update Book</title>
    <link type="text/css" rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<div class="container">
    <header>
        <h1>MyBooks</h1>
    </header>
    <form action="${pageContext.request.contextPath}/books" method="get">
        <input type="hidden" name="command" value="update"/>
        <input type="hidden" name="bookId" value="${book.id}"/>

        <label for="title">Enter a title:</label>
        <input id="title" name="title" type="text" value="${book.title}"/>

        <label for="author">Enter an author:</label>
        <input id="author" name="author" type="text" value="${book.author}"/>

        <button class="btn save-btn" type="submit">Save</button>
    </form>
    <p>Back to <a href="index.jsp">homepage</a>.</p>
</div>
</body>
</html>
