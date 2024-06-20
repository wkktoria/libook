package io.github.wkktoria.mybooks;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class BookDbUtil {
    private final DataSource dataSource;

    BookDbUtil(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    List<Book> getBooks() throws SQLException {
        List<Book> books = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            String sql = "select * from Books order by title";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int statusId = resultSet.getInt("status_id");

                Status status = new StatusDbUtil(dataSource).getStatus(statusId);

                books.add(new Book(id, title, author, status));
            }

            return books;
        } finally {
            close(connection, statement, resultSet);
        }
    }

    Book getBook(String id) throws SQLException {
        Book book;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int bookId;

        try {
            bookId = Integer.parseInt(id);

            connection = dataSource.getConnection();

            String sql = "select * from Books join Status on Books.status_id = Status.id where Books.id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, bookId);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                book = new Book(bookId, resultSet.getString("title"),
                        resultSet.getString("author"),
                        new Status(resultSet.getInt("status_id"), resultSet.getString("description")));
            } else {
                throw new SQLException("Book not found");
            }

            return book;
        } finally {
            close(connection, statement, resultSet);
        }
    }

    void addBook(Book book) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dataSource.getConnection();

            String sql = "insert into Books(title, author, status_id) values(?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getStatus().getId());

            statement.execute();
        } finally {
            close(connection, statement, null);
        }
    }

    void updateBook(Book book) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dataSource.getConnection();

            String sql = "update Books set title = ?, author = ?, status_id = ? where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getStatus().getId());
            statement.setInt(4, book.getId());

            statement.execute();
        } finally {
            close(connection, statement, null);
        }
    }

    void deleteBook(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        int bookId;

        try {
            bookId = Integer.parseInt(id);

            connection = dataSource.getConnection();

            String sql = "delete from Books where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, bookId);

            statement.execute();
        } finally {
            close(connection, statement, null);
        }
    }

    List<Book> searchBooks(String searchValue) throws SQLException {
        List<Book> books = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (searchValue == null || searchValue.isEmpty()) {
            return getBooks();
        }

        try {
            connection = dataSource.getConnection();

            String sql = "select * from Books where lower(title) like ? or lower(author) like ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + searchValue.toLowerCase() + "%");
            statement.setString(2, "%" + searchValue.toLowerCase() + "%");

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int statusId = resultSet.getInt("status_id");

                Status status = new StatusDbUtil(dataSource).getStatus(statusId);

                books.add(new Book(id, title, author, status));
            }

            return books;
        } finally {
            close(connection, statement, resultSet);
        }
    }

    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
