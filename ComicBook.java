package com.lavrovivan;

import java.io.Serializable;
// this class only to create a comic book scenario
public class ComicBook implements Serializable {
    private String bookName;
    private String authorName;
    private String publisher;
    private String pagesCount;
    private Genre genre;
    private int printYear;
    private int primeCost;
    private int endCustomerPrice;
    private char isSeries;
    private String isDecommissioned;
    private char isDiscounted;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(String pagesCount) {
        this.pagesCount = pagesCount;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getPrintYear() {
        return printYear;
    }

    public void setPrintYear(int printYear) {
        this.printYear = printYear;
    }

    public int getPrimeCost() {
        return primeCost;
    }

    public void setPrimeCost(int primeCost) {
        this.primeCost = primeCost;
    }

    public int getEndCustomerPrice() {
        return endCustomerPrice;
    }

    public void setEndCustomerPrice(int endCustomerPrice) {
        this.endCustomerPrice = endCustomerPrice;
    }

    public char isSeries() {
        return isSeries;
    }

    public void setSeries(char series) {
        isSeries = series;
    }

    public String isDecommissioned() {
        return isDecommissioned;
    }

    public void setDecommissioned(String decommissioned) {
        isDecommissioned = decommissioned;
    }

    public char getIsDiscounted() {
        return isDiscounted;
    }

    public void setIsDiscounted(char isDiscounted) {
        this.isDiscounted = isDiscounted;
    }
}
