package ru.omsu.imit.course32.daoimpl;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.omsu.imit.course32.dao.SectionBookDAO;
import ru.omsu.imit.course32.model.Book;
import ru.omsu.imit.course32.model.Section;

import java.util.List;

public class SectionBookDAOImpl extends BaseDAOImpl implements SectionBookDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(SectionBookDAOImpl.class);

    @Override
    public Integer insert(Section section, Book book) {
        LOGGER.debug("DAO Insert book's section {} {}", book, section);
        Integer result;
        try (SqlSession sqlSession = getSession()) {
            try {
                result = getSectionBookMapper(sqlSession).insert(book, section);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't insert book's section {} {}", book, section, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return result;
    }

    @Override
    public List<Book> getBooksBySection(Section section) {
        LOGGER.debug("DAO Getting books by section {}", section);
        try (SqlSession sqlSession = getSession()) {
            try {
                return getSectionBookMapper(sqlSession).getBooksBySection(section);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't get books by section {}", section, ex);
                sqlSession.rollback();
                throw ex;
            }
        }
    }

    @Override
    public List<Section> getSectionsByBook(Book book) {
        LOGGER.debug("DAO Getting book's sections {}", book);
        try (SqlSession sqlSession = getSession()) {
            try {
                return getSectionBookMapper(sqlSession).getSectionsByBook(book);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't get book's sections {}", book, ex);
                sqlSession.rollback();
                throw ex;
            }
        }
    }

    @Override
    public void deleteByISBNandSubject(String isbn, String subject) {
        LOGGER.debug("DAO Deleting link between book and section {} {}", isbn, subject);
        try (SqlSession sqlSession = getSession()) {
            try {
                getSectionBookMapper(sqlSession).deleteByISBNandSubject(isbn, subject);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete link between book and section {} {}", isbn, subject, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("DAO Deleting all links between books and sections");
        try (SqlSession sqlSession = getSession()) {
            try {
                getSectionBookMapper(sqlSession).deleteAll();
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete all links between books and sections", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }
}
