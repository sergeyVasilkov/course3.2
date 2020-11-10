package ru.omsu.imit.course32;

import org.junit.*;
import ru.omsu.imit.course32.dao.BookDAO;
import ru.omsu.imit.course32.daoimpl.BookDAOImpl;
import ru.omsu.imit.course32.model.Book;
import ru.omsu.imit.course32.utils.MyBatisUtils;

import static org.junit.Assert.*;

public class TestBookDAOImpl {
    BookDAO bookDAO = new BookDAOImpl();

    @BeforeClass()
    public static void init() {
        Assume.assumeTrue(MyBatisUtils.initSqlSessionFactory());
    }

    @Before()
    @After()
    public void clearDatabase() {
        bookDAO.deleteAll();
    }

    @Test
    public void testGetByOffset() {
        Book book = new Book(
                "myBookId",
                "author",
                1991,
                "title"
        );
        bookDAO.insert(book);
        assertFalse(bookDAO.getBooks(50, 0).isEmpty());
    }

    @Test
    public void testGetByISBN() {
        Book book = new Book(
                "myBookId",
                "author",
                1991,
                "title"
        );
        bookDAO.insert(book);
        Book returned = bookDAO.getBookByISBN("myBookId");
        assertEquals(book.getIsbn(), returned.getIsbn());
        assertEquals(book.getAuthor(), returned.getAuthor());
        assertEquals(book.getYear(), returned.getYear());
        assertEquals(book.getTitle(), returned.getTitle());
    }

    @Test
    public void testDeleteBookByISBN() {
        Book book = new Book(
                "myIdToDelete",
                "author",
                1991,
                "title"
        );
        bookDAO.insert(book);
        bookDAO.deleteByISBN("myIdToDelete");
        assertNull(bookDAO.getBookByISBN("myIdToDelete"));
    }
}
