package ru.omsu.imit.course32.daoimpl;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.omsu.imit.course32.dao.BookDAO;
import ru.omsu.imit.course32.model.Book;

import java.util.List;

public class BookDAOImpl extends BaseDAOImpl implements BookDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookDAOImpl.class);

    @Override
    public Book insert(Book book) {
        LOGGER.debug("DAO Insert Book {}", book);
        try (SqlSession sqlSession = getSession()) {
            try {
                getBookMapper(sqlSession).insert(book);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't insert Book {} {}", book, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return book;
    }

    @Override
    public List<Book> getBooks(int limit, int offset) {
        try (SqlSession sqlSession = getSession()) {
            return getBookMapper(sqlSession).getBooks(limit, offset);
        } catch (RuntimeException ex) {
            LOGGER.debug("Can't get Books", ex);
            throw ex;
        }
    }

    @Override
    public Book getBookByISBN(String ISBN) {
        try (SqlSession sqlSession = getSession()) {
            return getBookMapper(sqlSession).getBookByISBN(ISBN);
        } catch (RuntimeException ex) {
            LOGGER.debug("Can't get Books", ex);
            throw ex;
        }
    }

    @Override
    public void deleteByISBN(String isbn) {
        LOGGER.debug("DAO Delete Book by isbn {}", isbn);
        try (SqlSession sqlSession = getSession()) {
            try {
                getBookMapper(sqlSession).deleteByISBN(isbn);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete Book with isbn {} {}", isbn, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public void deleteAll() {
        try (SqlSession sqlSession = getSession()) {
            try {
                getBookMapper(sqlSession).deleteAll();
            } catch (RuntimeException ex) {
                LOGGER.debug("Error when clearing book table", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }
}
