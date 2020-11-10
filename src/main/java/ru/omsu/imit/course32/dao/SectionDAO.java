package ru.omsu.imit.course32.dao;

import ru.omsu.imit.course32.model.Section;

public interface SectionDAO {
    public Section insert(Section section);

    public Section getSectionBySubject(String subject);

    public void deleteBySubject(String subject);

    public void deleteAll();
}
