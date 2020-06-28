package com.xylon.book.service.Impl;

import com.xylon.book.mapper.BookMapper;
import com.xylon.book.model.Book;
import com.xylon.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;


    @Override
    public void AddBook(Book book) {
        bookMapper.AddBook(book);
    }

    @Override
    public void DeleteBook(Book book) {
        bookMapper.DeleteBook(book.getBookId());
    }

    @Override
    public void ChangeBook(Book book) {
        bookMapper.UpdateBookByBookName(book.getBookName());
        bookMapper.UpdateBookByBookDescription(book.getBookDescription());
        bookMapper.UpdateBookByBookImg(book.getBookImg());
        bookMapper.UpdateBookByBookRecommendReason(book.getBookRecommendReason());
        bookMapper.UpdateBookByBookTag(book.getBookTag());
        bookMapper.UpdateBookByBookPublishBy(book.getBookPublishBy());
    }
}
