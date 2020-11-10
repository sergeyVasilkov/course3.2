package ru.omsu.imit.course32.daoimpl;

import org.apache.ibatis.session.SqlSession;
import ru.omsu.imit.course32.mappers.*;
import ru.omsu.imit.course32.utils.MyBatisUtils;

public class BaseDAOImpl {
    protected SqlSession getSession() {
        return MyBatisUtils.getSqlSessionFactory().openSession();
    }

    protected BookMapper getBookMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(BookMapper.class);
    }

    protected LibraryMapper getLibraryMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(LibraryMapper.class);
    }

    protected SectionMapper getSectionMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(SectionMapper.class);
    }

    protected SectionBookMapper getSectionBookMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(SectionBookMapper.class);
    }

    protected ReaderMapper getReaderMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(ReaderMapper.class);
    }

    protected BookInstanceMapper getBookInstanceMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(BookInstanceMapper.class);
    }

}
