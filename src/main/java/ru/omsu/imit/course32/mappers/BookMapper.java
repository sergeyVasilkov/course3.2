package ru.omsu.imit.course32.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.omsu.imit.course32.model.Book;

import java.util.List;

public interface BookMapper {

    @Insert("INSERT INTO book (ISBN, AUTHOR, YEAR, TITLE) VALUES ( #{isbn}, #{author}, #{year}, #{title} )")
    public Integer insert(Book book);

    @Select("SELECT isbn, author, year, title FROM book WHERE isbn = #{isbn}")
    @Results({
            @Result(property = "isbn", column = "isbn")})
    public Book getBookByISBN(@Param("isbn") String isbn);

    @Select("SELECT * FROM book LIMIT #{limit} OFFSET #{offset} ")
    @Results({
            @Result(property = "isbn", column = "isbn")
    })
    public List<Book> getBooks(@Param("limit") int limit, @Param("offset") int offset);

    @Delete("DELETE FROM book WHERE book.isbn = #{isbn}")
    public void deleteByISBN(@Param("isbn") String isbn);

    @Delete("DELETE FROM book")
    public void deleteAll();
}
