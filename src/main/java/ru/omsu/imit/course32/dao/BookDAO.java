package ru.omsu.imit.course32.dao;

import ru.omsu.imit.course32.model.Book;

import java.util.List;

public interface BookDAO {
    public Book insert(Book book);

    public List<Book> getBooks(int limit, int offset);

    public Book getBookByISBN(String ISBN);

    public void deleteByISBN(String isbn);

    public void deleteAll();
}
