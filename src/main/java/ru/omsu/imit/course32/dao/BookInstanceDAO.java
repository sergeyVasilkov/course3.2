package ru.omsu.imit.course32.dao;

import ru.omsu.imit.course32.model.BookInstance;

import java.util.List;

public interface BookInstanceDAO {
    public BookInstance insert(BookInstance instance);

    public List<BookInstance> getBookInstancesByISBN(int limit, int offset, String isbn);

    public BookInstance getBookInstanceById(int id);

    public void deleteById(int id);

    public void deleteAll();
}
