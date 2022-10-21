package com.skyamit.buyAndSell.service;

import com.skyamit.buyAndSell.model.Book;
import com.skyamit.buyAndSell.model.Student;

import java.util.List;

public interface BookService {
    Book getBookById(int id);
    void deleteBook(int id);
    void updateBook(Book book);
    void uploadBook(String bookName,String authorName,int sellingPrice, int purchasePrice, Student student);
    List<Book> getBookByUploadId(int id);
    Book checkBook(int uploadId, int id);
    int totalPurchased(int purchaserId);
    List<Book> totalBooksPurchased(int purchasedId);
    int totalUploads(int uploadId);
    List<Book> availableBooks(int uploadId);
    List<Book> pendingBooks(int uploadId);
}
