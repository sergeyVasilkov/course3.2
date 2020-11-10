package ru.omsu.imit.course32;

import org.junit.*;
import ru.omsu.imit.course32.dao.BookDAO;
import ru.omsu.imit.course32.dao.SectionBookDAO;
import ru.omsu.imit.course32.dao.SectionDAO;
import ru.omsu.imit.course32.daoimpl.BookDAOImpl;
import ru.omsu.imit.course32.daoimpl.SectionBookDAOImpl;
import ru.omsu.imit.course32.daoimpl.SectionDAOImpl;
import ru.omsu.imit.course32.model.Book;
import ru.omsu.imit.course32.model.Section;
import ru.omsu.imit.course32.utils.MyBatisUtils;

import static org.junit.Assert.*;

public class TestSectionBookDAOImpl {
    SectionBookDAO sectionBookDAO = new SectionBookDAOImpl();
    SectionDAO sectionDAO = new SectionDAOImpl();
    BookDAO bookDAO = new BookDAOImpl();

    @BeforeClass()
    public static void init() {
        Assume.assumeTrue(MyBatisUtils.initSqlSessionFactory());
    }

    @Before()
    @After()
    public void clearDatabase() {
        sectionBookDAO.deleteAll();
        sectionDAO.deleteAll();
        bookDAO.deleteAll();
    }

    @Test
    public void testGetSectionsByBook() {
        Section section1 = new Section(
                "horror"
        );
        Section section2 = new Section(
                "classic"
        );
        Book book = new Book(
                "isbn1",
                "sergey",
                1999,
                "book_of_sergey"
        );
        sectionDAO.insert(section1);
        sectionDAO.insert(section2);
        bookDAO.insert(book);
        sectionBookDAO.insert(section1, book);
        sectionBookDAO.insert(section2, book);

        assertEquals(2, sectionBookDAO.getSectionsByBook(book).size());
    }

    @Test
    public void testGetBooksBySection() {
        Section section = new Section(
                "horror"
        );
        Book book1 = new Book(
                "isbn1",
                "sergey1",
                1999,
                "book_of_sergey1"
        );
        Book book2 = new Book(
                "isbn2",
                "sergey2",
                1998,
                "book_of_sergey2"
        );
        sectionDAO.insert(section);
        bookDAO.insert(book1);
        bookDAO.insert(book2);
        sectionBookDAO.insert(section, book1);
        sectionBookDAO.insert(section, book2);

        assertEquals(2, sectionBookDAO.getBooksBySection(section).size());
    }

}
