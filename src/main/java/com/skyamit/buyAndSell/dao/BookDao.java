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

    @Query(value = "select count(id) from book where purchaser_id=:purchaserId",nativeQuery = true)
    int totalPurchased(int purchaserId);

    @Query(value = "select count(id) from book where upload_id=:uploadId", nativeQuery = true)
    int totalUploads(int uploadId);

    @Query(value = "select * from book where upload_id!=:uploadId and purchaser_id=-1",nativeQuery = true)
    List<Book> availableBooks(int uploadId);

    @Query(value = "select * from book where purchaser_id=:purchaserId",nativeQuery = true)
    List<Book> totalBooksPurchased(int purchaserId);

    @Query(value = "select * from book where upload_id=:uploadId and status=1",nativeQuery = true)
    List<Book> pendingBooks(int uploadId);
}
