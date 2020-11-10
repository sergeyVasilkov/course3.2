package ru.omsu.imit.course32.mappers;

import org.apache.ibatis.annotations.*;
import ru.omsu.imit.course32.model.BookInstance;

import java.util.List;

public interface BookInstanceMapper {

    @Insert("INSERT INTO b_instance (idb_instance, date_get, date_return, library_address, book_isbn, available)" +
            " VALUES (#{id}, #{dateGet}, #{dateReturn}, #{libraryAddress}, #{isbn},#{available} )")
    public Integer insert(BookInstance instance);

    @Select("SELECT * FROM b_instance WHERE book_isbn = #{isbn} LIMIT #{limit} OFFSET #{offset}")
    public List<BookInstance> getBookInstancesByISBN(@Param("limit") int limit, @Param("offset") int offset, @Param("isbn") String isbn);

    @Select("SELECT * FROM b_instance WHERE idb_instance = #{id}")
    public BookInstance getBookInstanceById(@Param("id") int id);

    @Delete("DELETE FROM b_instance WHERE idb_instance = #{id}")
    public void deleteById(@Param("id") int id);

    @Delete("DELETE FROM b_instance")
    public void deleteAll();
}
