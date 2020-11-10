package ru.omsu.imit.course32.mappers;

import org.apache.ibatis.annotations.*;
import ru.omsu.imit.course32.model.Section;

public interface SectionMapper {
    @Insert("INSERT INTO section (subject) VALUES ( #{subject})")
    public Integer insert(Section section);

    @Select("SELECT subject FROM section WHERE subject = #{subject}")
    @Results({
            @Result(property = "subject", column = "subject")})
    public Section getSectionBySubject(@Param("subject") String subject);


    @Delete("DELETE FROM section WHERE section.subject = #{subject}")
    public void deleteBySubject(@Param("subject") String subject);

    @Delete("DELETE FROM section")
    public void deleteAll();
}
