package ru.omsu.imit.course32.model;

import java.util.Objects;

public class Reader {
    private int cardNum;
    private String fullName;
    private int phone;
    private String libraryAddress;

    public Reader(int cardNum, String fullName, int phone, String libraryAddress) {
        this.cardNum = cardNum;
        this.fullName = fullName;
        this.phone = phone;
        this.libraryAddress = libraryAddress;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

    public void setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "cardNum=" + cardNum +
                ", fullName='" + fullName + '\'' +
                ", phone=" + phone +
                ", library=" + libraryAddress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reader)) return false;
        Reader reader = (Reader) o;
        return getCardNum() == reader.getCardNum() &&
                getPhone() == reader.getPhone() &&
                Objects.equals(getFullName(), reader.getFullName()) &&
                Objects.equals(getLibraryAddress(), reader.getLibraryAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardNum(), getFullName(), getPhone(), getLibraryAddress());
    }
}
