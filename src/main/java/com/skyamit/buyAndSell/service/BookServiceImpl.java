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
    public void deleteBook(int id) {
        bookDao.deleteById(id);
    }

    @Override
    public void uploadBook(String bookName, String authorName, int sellingPrice, int purchasePrice, Student student) {
        Book book = new Book(bookName,authorName,purchasePrice,sellingPrice,Integer.parseInt(student.getId()+""),new Date(1,1,1),-1);
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
}
