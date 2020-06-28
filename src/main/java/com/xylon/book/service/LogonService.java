package com.xylon.book.service;

import com.xylon.book.model.User;

public interface LogonService {

    //check whether the invitation code in the DB
    boolean CheckInvitationCode(User user);

    //add the user into DB and return whether success to add
    void AddUser(User user);

}
