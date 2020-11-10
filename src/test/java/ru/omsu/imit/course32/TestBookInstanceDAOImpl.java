package ru.omsu.imit.course32;

import org.junit.*;
import ru.omsu.imit.course32.dao.BookDAO;
import ru.omsu.imit.course32.dao.BookInstanceDAO;
import ru.omsu.imit.course32.dao.LibraryDAO;
import ru.omsu.imit.course32.daoimpl.BookDAOImpl;
import ru.omsu.imit.course32.daoimpl.BookInstanceDAOImpl;
import ru.omsu.imit.course32.daoimpl.LibraryDAOImpl;
import ru.omsu.imit.course32.model.Book;
import ru.omsu.imit.course32.model.BookInstance;
import ru.omsu.imit.course32.model.Library;
import ru.omsu.imit.course32.utils.MyBatisUtils;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.Assert.*;

public class TestBookInstanceDAOImpl {
    LibraryDAO libraryDAO = new LibraryDAOImpl();
    BookDAO bookDAO = new BookDAOImpl();
    BookInstanceDAO bookInstanceDAO = new BookInstanceDAOImpl();

    @BeforeClass()
    public static void init() {
        Assume.assumeTrue(MyBatisUtils.initSqlSessionFactory());
    }

    @Before()
    @After()
    public void clearDatabase() {
        bookInstanceDAO.deleteAll();
        bookDAO.deleteAll();
        libraryDAO.deleteAll();
    }

    @Test
    public void testGetBookInstancesByISBN() {
        Book book = new Book(
                "myBookId",
                "author",
                1991,
                "title"
        );
        Library library = new Library("library");
        BookInstance instance = new BookInstance(1,
                Timestamp.from(Instant.now()),
                Timestamp.from(Instant.now()),
                1,
                library.getAddress(),
                book.getIsbn()
        );
        bookDAO.insert(book);
        libraryDAO.insert(library);
        bookInstanceDAO.insert(instance);
        assertFalse(bookInstanceDAO.getBookInstancesByISBN(50, 0, book.getIsbn()).isEmpty());
    }

    @Test
    public void testGetBookInstanceById() {
        Book book = new Book(
                "myBookId1",
                "author",
                1991,
                "title"
        );
        Library library = new Library("library1");
        BookInstance instance = new BookInstance(404,
                Timestamp.from(Instant.now()),
                Timestamp.from(Instant.now()),
                1,
                library.getAddress(),
                book.getIsbn()
        );
        bookDAO.insert(book);
        libraryDAO.insert(library);
        bookInstanceDAO.insert(instance);
        BookInstance returned = bookInstanceDAO.getBookInstanceById(404);
        assertEquals(instance.getId(), returned.getId());
        assertEquals(instance.getIsbn(), returned.getIsbn());
        assertEquals(instance.getLibraryAddress(), returned.getLibraryAddress());
    }

    @Test
    public void testDeleteBookInstanceById() {
        Book book = new Book(
                "myBookId2",
                "author",
                1991,
                "title"
        );
        Library library = new Library("library2");
        BookInstance instance = new BookInstance(40400,
                Timestamp.from(Instant.now()),
                Timestamp.from(Instant.now()),
                1,
                library.getAddress(),
                book.getIsbn()
        );
        bookDAO.insert(book);
        libraryDAO.insert(library);
        bookInstanceDAO.insert(instance);
        bookInstanceDAO.deleteById(40400);
        assertNull(bookInstanceDAO.getBookInstanceById(40400));
    }
}
