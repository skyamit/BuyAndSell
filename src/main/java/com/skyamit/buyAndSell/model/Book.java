package com.skyamit.buyAndSell.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String bookName;
    String bookAuthor;

    int purchasePrice;
    int sellingPrice;

    int uploadId;
    Date uploadDate;
    int purchaserId;
    int status;

    public Book(){}

    public Book(String bookName, String bookAuthor, int purchasePrice, int sellingPrice, int uploadId, Date uploadDate, int purchaserId, int status) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.uploadId = uploadId;
        this.uploadDate = uploadDate;
        this.purchaserId = purchaserId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getUploadId() {
        return uploadId;
    }

    public void setUploadId(int uploadId) {
        this.uploadId = uploadId;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(int purchaserId) {
        this.purchaserId = purchaserId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
