package ru.omsu.imit.course32.daoimpl;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.omsu.imit.course32.dao.ReaderDAO;
import ru.omsu.imit.course32.model.Reader;

public class ReaderDAOImpl extends BaseDAOImpl implements ReaderDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(LibraryDAOImpl.class);

    @Override
    public Reader insert(Reader reader) {
        LOGGER.debug("DAO Insert Reader {}", reader);
        try (SqlSession sqlSession = getSession()) {
            try {
                getReaderMapper(sqlSession).insert(reader);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't insert Reader {} {}", reader, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return reader;
    }

    @Override
    public Reader getReaderByCardNum(int cardNum) {
        LOGGER.debug("DAO Get Reader by cardNum {}", cardNum);
        try (SqlSession sqlSession = getSession()) {
            try {
                return getReaderMapper(sqlSession).getReaderByCardNum(cardNum);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't get Reader by cardNum {} {}", cardNum, ex);
                sqlSession.rollback();
                throw ex;
            }
        }
    }

    @Override
    public void deleteByCardNum(int cardNum) {
        LOGGER.debug("DAO Delete Reader by cardNum  {}", cardNum);
        try (SqlSession sqlSession = getSession()) {
            try {
                getReaderMapper(sqlSession).deleteByCardNum(cardNum);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete Reader by cardNum {} {}", cardNum, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("DAO Delete all Reader");
        try (SqlSession sqlSession = getSession()) {
            try {
                getReaderMapper(sqlSession).deleteAll();
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete all Reader", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }
}
