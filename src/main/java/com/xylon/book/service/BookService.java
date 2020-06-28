package com.xylon.book.service;

import com.xylon.book.model.Book;


public interface BookService {

    void AddBook(Book book);

    void DeleteBook(Book book);

    void ChangeBook(Book book);


}
