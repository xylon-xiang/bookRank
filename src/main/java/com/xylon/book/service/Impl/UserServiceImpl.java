package com.xylon.book.service.Impl;


import com.xylon.book.mapper.UserMapper;
import com.xylon.book.model.User;
import com.xylon.book.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void UpdateUserInformation(User user) {
        userMapper.UpdateUserName(user.getUserName());
        userMapper.UpdateUserPassword(user.getUserPassword());
        userMapper.UpdateUserEmail(user.getUserEmail());

        log.info("the user " + user.getUserId() + " update its information.");
    }

    @Override
    public User GetUserInfo(long userId) {
        return userMapper.SearchUserByUserId(userId);
    }
}
