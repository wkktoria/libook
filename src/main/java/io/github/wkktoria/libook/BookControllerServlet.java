package io.github.wkktoria.libook;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "bookControllerServlet", value = "/books")
public class BookControllerServlet extends HttpServlet {
    private BookDbUtil bookDbUtil;
    @Resource(name = "jdbc/libook")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        bookDbUtil = new BookDbUtil(dataSource);
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        try {
            String command = req.getParameter("command");

            if (command == null) {
                command = "list";
            }

            switch (command) {
                case "load":
                    loadBook(req, resp);
                    break;
                case "update":
                    updateBook(req, resp);
                    break;
                case "delete":
                    deleteBook(req, resp);
                    break;
                case "search":
                    searchBooks(req, resp);
                    break;
                case "list":
                default:
                    listBooks(req, resp);
                    break;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        try {
            String command = req.getParameter("command");

            if (command.equals("add")) {
                addBook(req, resp);
            } else {
                listBooks(req, resp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listBooks(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Book> books = bookDbUtil.getBooks();
        req.setAttribute("books", books);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/listBooks.jsp");
        dispatcher.forward(req, resp);
    }

    private void addBook(final HttpServletRequest req, final HttpServletResponse resp) throws IOException, SQLException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        Status status = new StatusDbUtil(dataSource).getStatus(Integer.parseInt(req.getParameter("statusId")));

        bookDbUtil.addBook(new Book(title, author, status));

        resp.sendRedirect(req.getContextPath() + "/books");
    }

    private void loadBook(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String bookId = req.getParameter("bookId");
        Book book = bookDbUtil.getBook(bookId);

        req.setAttribute("book", book);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/updateBookForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void updateBook(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        Status status = new StatusDbUtil(dataSource).getStatus(Integer.parseInt(req.getParameter("statusId")));


        Book book = new Book(bookId, title, author, status);
        bookDbUtil.updateBook(book);

        listBooks(req, resp);
    }

    private void deleteBook(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String bookId = req.getParameter("bookId");

        bookDbUtil.deleteBook(bookId);

        listBooks(req, resp);
    }

    private void searchBooks(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String searchValue = req.getParameter("searchValue");
        List<Book> books = bookDbUtil.searchBooks(searchValue);

        req.setAttribute("books", books);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/listBooks.jsp");
        dispatcher.forward(req, resp);
    }
}
