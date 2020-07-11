package com.xylon.book.controller;

import com.xylon.book.model.Book;
import com.xylon.book.service.SearchService;
import com.xylon.book.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    SearchService searchService;

    JsonUtil jsonUtil = new JsonUtil();

    @GetMapping("/book/random")
    public String GetRandomBook(){
        List<Book> bookList = searchService.SearchBookByRandom();

        return jsonUtil.ClassIntoJson(bookList);
    }

    @GetMapping("/book")
    public String GetBook(@RequestParam("keyword") String keyWord,
                          @RequestParam("tag") String tag){

        List<Book> bookList = searchService.SearchBookByName(keyWord);
        List<Book> bookList_tag = searchService.SearchBookByBookTag(tag);

        bookList.addAll(bookList_tag);

        return jsonUtil.ClassIntoJson(bookList);
    }

}
