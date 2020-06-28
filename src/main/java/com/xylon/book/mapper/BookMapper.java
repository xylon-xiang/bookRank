package com.xylon.book.mapper;

import com.xylon.book.model.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    @Insert(value = "INSERT INTO Book (bookId, bookName, bookDescription, bookImg, bookRecommendReason," +
            " bookTag, bookPublishBy) VALUES (#{bookId}, #{bookName}, #{bookDescription}, #{bookImg}, " +
            "#{bookRecommendReason}, #{bookTag}, #{bookPublish})")
    void AddBook(Book book);

    @Delete(value = "DELETE FROM Book WHERE bookId=#{bookId}")
    void DeleteBook(@Param("bookId") int bookId);

    @Update(value = "UPDATE Book SET bookName = #{bookName}")
    void UpdateBookByBookName(@Param("bookName") String bookName);

    @Update(value = "UPDATE Book SET bookDescription = #{bookDescription}")
    void UpdateBookByBookDescription(@Param("bookDescription") String bookDescription);

    @Update(value = "UPDATE Book SET bookImg = #{bookImg}")
    void UpdateBookByBookImg(@Param("bookImg") String bookImg);

    @Update(value = "UPDATE Book SET bookRecommendReason = #{bookRecommendReason}")
    void UpdateBookByBookRecommendReason(@Param("bookRecommendReason") String bookRecommendReason);

    @Update(value = "UPDATE Book SET bookTag = #{bookTag}")
    void UpdateBookByBookTag(@Param("bookTag") String bookTag);

    @Update(value = "UPDATE Book SET bookPublishBy = #{bookPublishBy}")
    void UpdateBookByBookPublishBy(@Param("bookPublishBy") long bookPublishBy);


    @Select(value = "SELECT bookId FROM Book")
    List<Integer> SearchAllBookId();

    @Select(value = "SELECT * FROM Book WHERE bookTag LIKE '%${bookTag}%'")
    List<Book> SearchBookByBookTag(@Param("bookTag") String bookTag);

    @Select(value = "SELECT * FROM Book WHERE bookName LIKE '%${bookName}%'")
    List<Book> SearchBookByBookName(@Param("BookName") String bookName);

    @Select(value = "SELECT * FROM Book WHERE bookId = #{bookId}")
    Book SearchBookByBookId(@Param("bookId") int bookId);

    @Select(value = "SELECT * FROM Book WHERE bookPublishBy = #{bookPublishBy}")
    List<Book> SearchBookByBookPublishBy(@Param("bookPublishBy") long bookPublishBy);
}
