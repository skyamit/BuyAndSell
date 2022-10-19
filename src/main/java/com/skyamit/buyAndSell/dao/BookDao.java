package com.skyamit.buyAndSell.dao;

import com.skyamit.buyAndSell.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> {

    @Query(value = "select * from book where upload_id=:uploadId order by id desc",nativeQuery = true)
    List<Book> findByUploadId(int uploadId);

    @Query(value = "select * from book where upload_id=:uploadId && id=:id ",nativeQuery = true)
    Book checkBook(int uploadId,int id);
}
