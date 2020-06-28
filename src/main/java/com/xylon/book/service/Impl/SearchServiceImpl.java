package com.xylon.book.service.Impl;

import com.xylon.book.mapper.BookMapper;
import com.xylon.book.mapper.UserMapper;
import com.xylon.book.model.Book;
import com.xylon.book.model.User;
import com.xylon.book.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    BookMapper bookMapper;
    @Autowired
    UserMapper userMapper;


    @Override
    public List<Book> SearchBookByUser(User user) {
        List<Book> bookList = new ArrayList<>();
        for (long i : userMapper.SearchUserIdByUserName(user.getUserName())){
            bookList.addAll(bookMapper.SearchBookByBookPublishBy(i));
        }
        return bookList;
    }

    @Override
    public List<Book> SearchBookByName(String bookName) {
        List<Book> bookList = new ArrayList<>();

        bookMapper.SearchBookByBookName(bookName);


        return bookList;
    }

    @Override
    public List<Book> SearchBookByBookTag(String bookTag) {
        return new ArrayList<>(bookMapper.SearchBookByBookTag(bookTag));
    }

    @Override
    public List<Book> SearchBookByRandom() {
        List<Book> bookList = new ArrayList<>();

        List<Integer> book_id_list = new ArrayList<>(bookMapper.SearchAllBookId());

        int length = book_id_list.size();

        Random random = new Random();

        //show the five random book
        for (int i = 0; i < 5 && i < length; i++){
            int index = random.nextInt(length);
            bookList.add(bookMapper.SearchBookByBookId(book_id_list.get(index)));
        }

        return bookList;
    }
}
