package com.xylon.book.service.Impl;

import com.xylon.book.mapper.UserMapper;
import com.xylon.book.model.User;
import com.xylon.book.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean CheckUser(User user) {

        boolean success = false;

        if(!userMapper.SearchUserIdByUserId(user.getUserId()).isEmpty()){
            if(userMapper.SearchUserPasswordByUserId(user.getUserId()).equals(user.getUserPassword()))
                success = true;
        }
        else if(!userMapper.SearchUserIdByUserEmail(user.getUserEmail()).isEmpty()){
            List<Long> user_id = userMapper.SearchUserIdByUserEmail(user.getUserEmail());

            if(userMapper.SearchUserPasswordByUserId(user_id.get(0)).equals(user.getUserPassword()))
                success = true;

        }

        return success;
    }

}
