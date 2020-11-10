package ru.omsu.imit.course32.dao;

import ru.omsu.imit.course32.model.Reader;

public interface ReaderDAO {
    public Reader insert(Reader reader);

    public Reader getReaderByCardNum(int cardNum);

    public void deleteByCardNum(int cardNum);

    public void deleteAll();
}
