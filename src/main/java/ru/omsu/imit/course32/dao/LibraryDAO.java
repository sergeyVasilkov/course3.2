package ru.omsu.imit.course32.dao;

import ru.omsu.imit.course32.model.Library;

public interface LibraryDAO {
    public Library insert(Library library);

    public Library getLibraryByAddress(String address);

    public void deleteByAddress(String address);

    public void deleteAll();
}
