package ru.omsu.imit.course32.model;

import java.util.Objects;

public class Section {
    private String subject;

    public Section(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Section{" +
                "subject='" + subject + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section)) return false;
        Section section = (Section) o;
        return Objects.equals(getSubject(), section.getSubject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubject());
    }
}
