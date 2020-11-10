package ru.omsu.imit.course32.daoimpl;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.omsu.imit.course32.dao.SectionDAO;
import ru.omsu.imit.course32.model.Section;

public class SectionDAOImpl extends BaseDAOImpl implements SectionDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(SectionDAOImpl.class);

    @Override
    public Section insert(Section section) {
        LOGGER.debug("DAO insert Section  {}", section);
        try (SqlSession sqlSession = getSession()) {
            try {
                getSectionMapper(sqlSession).insert(section);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't insert section {} {}", section, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return section;
    }

    @Override
    public Section getSectionBySubject(String subject) {
        LOGGER.debug("DAO get Section by subject {}", subject);
        try (SqlSession sqlSession = getSession()) {
            try {
             return getSectionMapper(sqlSession).getSectionBySubject(subject);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't get section by subject {} {}", subject, ex);
                sqlSession.rollback();
                throw ex;
            }
        }
    }

    @Override
    public void deleteBySubject(String subject) {
        LOGGER.debug("DAO delete Section by subject {}", subject);
        try (SqlSession sqlSession = getSession()) {
            try {
                getSectionMapper(sqlSession).deleteBySubject(subject);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete section by subject {} {}", subject, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("DAO get Section by subject ");
        try (SqlSession sqlSession = getSession()) {
            try {
                getSectionMapper(sqlSession).deleteAll();
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't get section by subject ",ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }
}
