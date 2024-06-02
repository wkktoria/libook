package io.github.wkktoria.mybooks;

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
    @Resource(name = "jdbc/mybooks")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        bookDbUtil = new BookDbUtil(dataSource);
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        try {
            listBooks(req, resp);
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
}
