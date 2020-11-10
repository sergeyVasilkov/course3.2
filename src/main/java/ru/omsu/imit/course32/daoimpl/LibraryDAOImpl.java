package ru.omsu.imit.course32.daoimpl;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.omsu.imit.course32.dao.LibraryDAO;
import ru.omsu.imit.course32.model.Library;

public class LibraryDAOImpl extends BaseDAOImpl implements LibraryDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(LibraryDAOImpl.class);

    @Override
    public Library insert(Library library) {
        LOGGER.debug("DAO Insert Library {}", library);
        try (SqlSession sqlSession = getSession()) {
            try {
                getLibraryMapper(sqlSession).insert(library);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't insert Library {} {}", library, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return library;
    }

    @Override
    public Library getLibraryByAddress(String address) {
        LOGGER.debug("DAO Get Library by Address {}", address);
        try (SqlSession sqlSession = getSession()) {
            try {
                return getLibraryMapper(sqlSession).getLibraryByAddress(address);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't get Library by address {} {}", address, ex);
                sqlSession.rollback();
                throw ex;
            }
        }
    }

    @Override
    public void deleteByAddress(String address) {
        LOGGER.debug("DAO Delete Library by address  {}", address);
        try (SqlSession sqlSession = getSession()) {
            try {
                getLibraryMapper(sqlSession).deleteByAddress(address);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete Library by address {} {}", address, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("DAO Delete all Library");
        try (SqlSession sqlSession = getSession()) {
            try {
                getLibraryMapper(sqlSession).deleteAll();
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete all Library", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }
}
