package ru.omsu.imit.course32.mappers;

import org.apache.ibatis.annotations.*;
import ru.omsu.imit.course32.model.Book;
import ru.omsu.imit.course32.model.Section;

import java.util.List;

public interface SectionBookMapper {

    @Insert("INSERT INTO section_has_book (book_isbn, section_subject) VALUES ( #{book.isbn} ,#{section.subject})")
    public Integer insert(@Param("book")Book book, @Param("section") Section section);

    @Select("SELECT subject FROM section " +
                "LEFT JOIN section_has_book on section_has_book.section_subject = section.subject " +
                "WHERE section_has_book.book_isbn = #{book.isbn}")
    public List<Section> getSectionsByBook(@Param("book") Book book);

    @Select("SELECT isbn, author, year, title FROM book " +
            "LEFT JOIN section_has_book on section_has_book.book_isbn = book.isbn " +
            "WHERE section_has_book.section_subject = #{section.subject}")
    public List<Book> getBooksBySection(@Param("section") Section section);


    @Delete("DELETE FROM section_has_book WHERE section_has_book.book_isbn = #{isbn}, section_has_book.section_subject = #{subject}")
    public void deleteByISBNandSubject(@Param("isbn") String isbn, @Param("subject") String subject);

    @Delete("DELETE FROM section_has_book")
    public void deleteAll();

}
