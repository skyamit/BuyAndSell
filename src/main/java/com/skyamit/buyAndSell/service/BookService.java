package com.skyamit.buyAndSell.service;

import com.skyamit.buyAndSell.model.Book;
import com.skyamit.buyAndSell.model.Student;

import java.util.List;

public interface BookService {
    void deleteBook(int id);
    void uploadBook(String bookName,String authorName,int sellingPrice, int purchasePrice, Student student);
    List<Book> getBookByUploadId(int id);

    Book checkBook(int uploadId, int id);
}
