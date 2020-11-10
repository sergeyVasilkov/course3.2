package ru.omsu.imit.course32.model;

import java.util.List;
import java.util.Objects;

public class Book {
    private String isbn;
    private String author;
    private int year;
    private String title;
    private List<Section> sections;

    public Book(String isbn, String author, int year, String title) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public Book(String isbn, String author, int year, String title, List<Section> sections) {
        this.isbn = isbn;
        this.author = author;
        this.year = year;
        this.title = title;
        this.sections = sections;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", sections=" + sections +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getYear() == book.getYear() &&
                Objects.equals(getIsbn(), book.getIsbn()) &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getSections(), book.getSections());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbn(), getAuthor(), getYear(), getTitle(), getSections());
    }
}
