package ru.omsu.imit.course32;

import org.junit.*;
import ru.omsu.imit.course32.dao.LibraryDAO;
import ru.omsu.imit.course32.dao.ReaderDAO;
import ru.omsu.imit.course32.daoimpl.LibraryDAOImpl;
import ru.omsu.imit.course32.daoimpl.ReaderDAOImpl;
import ru.omsu.imit.course32.model.Library;
import ru.omsu.imit.course32.model.Reader;
import ru.omsu.imit.course32.utils.MyBatisUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestReaderDAOImpl {
    ReaderDAO readerDAO = new ReaderDAOImpl();
    LibraryDAO libraryDAO = new LibraryDAOImpl();

    @BeforeClass()
    public static void init() {
        Assume.assumeTrue(MyBatisUtils.initSqlSessionFactory());
    }

    @Before()
    @After()
    public void clearDatabase() {
        readerDAO.deleteAll();
        libraryDAO.deleteAll();
    }

    @Test
    public void testGetByCardNum() {
        Library library = new Library("library");
        Reader reader = new Reader(1, "sergey", 2, library.getAddress());

        libraryDAO.insert(library);
        readerDAO.insert(reader);

        Reader returned = readerDAO.getReaderByCardNum(1);
        assertEquals(reader, returned);
    }

    @Test
    public void testDeleteReaderByCardNum() {
        Library library = new Library(
                "testDelete"
        );

        Reader reader = new Reader(100, "sergey", 2, library.getAddress());

        libraryDAO.insert(library);
        readerDAO.insert(reader);

        readerDAO.deleteByCardNum(100);
        assertNull(readerDAO.getReaderByCardNum(100));
    }
}
