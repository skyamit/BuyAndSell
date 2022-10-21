package com.skyamit.buyAndSell.service;

import com.skyamit.buyAndSell.dao.BookDao;
import com.skyamit.buyAndSell.model.Book;
import com.skyamit.buyAndSell.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookDao bookDao;

    @Override
    public Book getBookById(int id) {
        return bookDao.getReferenceById(id);
    }

    @Override
    public void deleteBook(int id) {
        bookDao.deleteById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.save(book);
    }

    @Override
    public void uploadBook(String bookName, String authorName, int sellingPrice, int purchasePrice, Student student) {
        Book book = new Book(bookName,authorName,purchasePrice,sellingPrice,Integer.parseInt(student.getId()+""),new Date(1,1,1),-1,0);
        bookDao.save(book);
    }

    @Override
    public List<Book> getBookByUploadId(int uploadId) {
        return bookDao.findByUploadId(uploadId);
    }

    @Override
    public Book checkBook(int uploadId, int id) {
        return bookDao.checkBook(uploadId,id);
    }

    @Override
    public int totalPurchased(int purchaserId) {
        return bookDao.totalPurchased(purchaserId);
    }

    @Override
    public List<Book> totalBooksPurchased(int purchaserId) {
        return bookDao.totalBooksPurchased(purchaserId);
    }

    @Override
    public int totalUploads(int uploadId) {
        return bookDao.totalUploads(uploadId);
    }

    @Override
    public List<Book> availableBooks(int uploadId) {
        return bookDao.availableBooks(uploadId);
    }

    @Override
    public List<Book> pendingBooks(int uploadId){
        return bookDao.pendingBooks(uploadId);
    }
}
