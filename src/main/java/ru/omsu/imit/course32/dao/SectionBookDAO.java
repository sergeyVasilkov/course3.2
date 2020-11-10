package ru.omsu.imit.course32.dao;

import ru.omsu.imit.course32.model.Book;
import ru.omsu.imit.course32.model.Section;

import java.util.List;

public interface SectionBookDAO {
    public Integer insert(Section section, Book book);

    public List<Book> getBooksBySection(Section section);

    public List<Section> getSectionsByBook(Book book);

    public void deleteByISBNandSubject(String isbn,String subject);

    public void deleteAll();
}
