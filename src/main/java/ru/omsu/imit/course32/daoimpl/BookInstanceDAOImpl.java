package ru.omsu.imit.course32.daoimpl;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.omsu.imit.course32.dao.BookInstanceDAO;
import ru.omsu.imit.course32.model.BookInstance;

import java.util.List;

public class BookInstanceDAOImpl extends BaseDAOImpl implements BookInstanceDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookInstanceDAOImpl.class);

    @Override
    public BookInstance insert(BookInstance instance) {
        LOGGER.debug("DAO Insert Book instance {}", instance);
        try (SqlSession sqlSession = getSession()) {
            try {
                getBookInstanceMapper(sqlSession).insert(instance);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't insert Book instance {} {}", instance, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return instance;
    }

    @Override
    public List<BookInstance> getBookInstancesByISBN(int limit, int offset, String isbn) {
        try (SqlSession sqlSession = getSession()) {
            return getBookInstanceMapper(sqlSession).getBookInstancesByISBN(limit, offset, isbn);
        } catch (RuntimeException ex) {
            LOGGER.debug("Can't get Book instances", ex);
            throw ex;
        }
    }

    @Override
    public BookInstance getBookInstanceById(int id) {
        try (SqlSession sqlSession = getSession()) {
            return getBookInstanceMapper(sqlSession).getBookInstanceById(id);
        } catch (RuntimeException ex) {
            LOGGER.debug("Can't get Book instance by id ", ex);
            throw ex;
        }
    }

    @Override
    public void deleteById(int id) {
        LOGGER.debug("DAO Delete Book instance by id {}", id);
        try (SqlSession sqlSession = getSession()) {
            try {
                getBookInstanceMapper(sqlSession).deleteById(id);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete Book instance with id {} {}", id, ex);
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
                getBookInstanceMapper(sqlSession).deleteAll();
            } catch (RuntimeException ex) {
                LOGGER.debug("Error when clearing book instance table", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }
}
