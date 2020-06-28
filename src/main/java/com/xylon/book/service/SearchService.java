package com.xylon.book.service;

import com.xylon.book.model.Book;
import com.xylon.book.model.User;

import java.util.List;

public interface SearchService {

    List<Book> SearchBookByUser(User user);

    List<Book> SearchBookByName(String bookName);

    List<Book> SearchBookByBookTag(String bookTag);

    List<Book> SearchBookByRandom();

}
