package com.xylon.book.util;

import com.xylon.book.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class GenerateUserId {

    @Autowired
    UserMapper userMapper;

    public long GenerateUID(){
        long user_id = userMapper.SearchLastUserId();

        Random random = new Random();

        return user_id + random.nextInt(10000);

    }

}
