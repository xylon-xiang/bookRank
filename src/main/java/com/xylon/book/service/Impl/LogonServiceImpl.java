package com.xylon.book.service.Impl;

import com.xylon.book.mapper.InvitationCodeMapper;
import com.xylon.book.mapper.UserMapper;
import com.xylon.book.model.User;
import com.xylon.book.service.LogonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class LogonServiceImpl implements LogonService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    InvitationCodeMapper invitationCodeMapper;

    @Override
    public boolean CheckInvitationCode(User user) {

        boolean success = false;

        if(invitationCodeMapper.IsUsed(user.getInvitationCode()) == 1)
            success = true;

        return success;
    }

    @Override
    public void AddUser(User user) {

        userMapper.AddUser(user);

        Date date = new Date();

        boolean isInDB = true;
        do {
            if(userMapper.SearchUserIdByUserId(user.getUserId()).isEmpty()){
                isInDB = false;
                log.info(date.toString() + "Assert an user unsuccessfully"+ user.getUserId());
                userMapper.AddUser(user);
            }
        }while (!isInDB);

        log.info(date.toString() + "Assert an user successfully." + user.getUserId());
    }
}
