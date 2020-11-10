package ru.omsu.imit.course32.model;

import java.sql.Timestamp;
import java.util.Objects;

public class BookInstance {
    private int id;
    private Timestamp dateGet;
    private Timestamp dateReturn;
    private int available;
    private String libraryAddress;
    private String isbn;

    public BookInstance(int id, Timestamp dateGet, Timestamp dateReturn, int available, String libraryAddress, String isbn) {
        this.id = id;
        this.dateGet = dateGet;
        this.dateReturn = dateReturn;
        this.available = available;
        this.libraryAddress = libraryAddress;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDateGet() {
        return dateGet;
    }

    public void setDateGet(Timestamp dateGet) {
        this.dateGet = dateGet;
    }

    public Timestamp getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Timestamp dateReturn) {
        this.dateReturn = dateReturn;
    }

    public int isAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

    public void setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "BookInstance{" +
                "id=" + id +
                ", dateGet=" + dateGet +
                ", dateReturn=" + dateReturn +
                ", available=" + available +
                ", libraryAddress='" + libraryAddress + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookInstance)) return false;
        BookInstance that = (BookInstance) o;
        return getId() == that.getId() &&
                isAvailable() == that.isAvailable() &&
                Objects.equals(getDateGet(), that.getDateGet()) &&
                Objects.equals(getDateReturn(), that.getDateReturn()) &&
                Objects.equals(getLibraryAddress(), that.getLibraryAddress()) &&
                Objects.equals(getIsbn(), that.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateGet(), getDateReturn(), isAvailable(), getLibraryAddress(), getIsbn());
    }

}
