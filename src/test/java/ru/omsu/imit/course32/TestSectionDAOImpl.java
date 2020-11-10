package ru.omsu.imit.course32;

import org.junit.*;
import ru.omsu.imit.course32.dao.SectionDAO;
import ru.omsu.imit.course32.daoimpl.SectionDAOImpl;
import ru.omsu.imit.course32.model.Section;
import ru.omsu.imit.course32.utils.MyBatisUtils;

import static org.junit.Assert.*;

public class TestSectionDAOImpl {
    SectionDAO sectionDAO = new SectionDAOImpl();

    @BeforeClass()
    public static void init() {
        Assume.assumeTrue(MyBatisUtils.initSqlSessionFactory());
    }

    @Before()
    @After()
    public void clearDatabase() {
        sectionDAO.deleteAll();
    }

    @Test
    public void testGetBySubject() {
        Section section = new Section(
                "horror"
        );
        sectionDAO.insert(section);

        Section returned = sectionDAO.getSectionBySubject("horror");
        assertEquals(section.getSubject(), returned.getSubject());
    }

    @Test
    public void testDeleteSectionBySubject() {
        Section section = new Section(
                "testDelete"
        );
        sectionDAO.insert(section);
        sectionDAO.deleteBySubject("testDelete");
        assertNull(sectionDAO.getSectionBySubject("testDelete"));
    }
}
