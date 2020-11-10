package ru.omsu.imit.course32;

import org.junit.*;
import ru.omsu.imit.course32.dao.LibraryDAO;
import ru.omsu.imit.course32.daoimpl.LibraryDAOImpl;
import ru.omsu.imit.course32.model.Library;
import ru.omsu.imit.course32.model.Section;
import ru.omsu.imit.course32.utils.MyBatisUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestLibraryDAOImpl {
    LibraryDAO libraryDAO = new LibraryDAOImpl();

    @BeforeClass()
    public static void init() {
        Assume.assumeTrue(MyBatisUtils.initSqlSessionFactory());
    }

    @Before()
    @After()
    public void clearDatabase() {
        libraryDAO.deleteAll();
    }

    @Test
    public void testGetBySubject() {
        Library library = new Library(
                "liba"
        );
        libraryDAO.insert(library);

        Library returned = libraryDAO.getLibraryByAddress("liba");
        assertEquals(library.getAddress(), returned.getAddress());
    }

    @Test
    public void testDeleteSectionBySubject() {
        Library library = new Library(
                "testDelete"
        );
        libraryDAO.insert(library);
        libraryDAO.deleteByAddress("testDelete");
        assertNull(libraryDAO.getLibraryByAddress("testDelete"));
    }
}
