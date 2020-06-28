package com.xylon.book.model;

import lombok.Data;

@Data
public class Book {

    private int bookId;

    private String bookName;

    private String bookDescription;

    private String bookImg;

    private String bookRecommendReason;

    private String bookTag;

    private long bookPublishBy;
}
