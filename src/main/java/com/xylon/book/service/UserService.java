package com.xylon.book.service;

import com.xylon.book.model.User;

public interface UserService {

    void UpdateUserInformation(User user);

    User GetUserInfo(long userId);

}
