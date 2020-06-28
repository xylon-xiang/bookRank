package com.xylon.book.mapper;


import com.xylon.book.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {

    @Insert(value = "INSERT INTO User (userId, userEmail, userName, userPassword, invitationCode) " +
            "VALUES (#{userId}, #{userEmail}, #{userName}, #{userPassword}, #{invitationCode})")
    void AddUser(User user);

    @Update(value = "UPDATE User SET userName = #{userName}")
    void UpdateUserName(@Param("userName") String userName);

    @Update(value = "UPDATE User SET userPassword = #{userPassword}")
    void UpdateUserPassword(@Param("userPassword") String userPassword);

    @Update(value = "UPDATE User SET userEmail = #{userEmail}")
    void UpdateUserEmail(@Param("userEmail") String userEmail);


    @Select(value = "SELECT invitationCode FROM User WHERE userId = #{userId}")
    int SearchInvitationCodeByUserId(@Param("userId") long userId);

    @Select(value = "SELECT userId FROM User WHERE userName = #{userName}")
    List<Long> SearchUserIdByUserName(@Param("userName") String userName);

    //the function is to check whether the userId in the DB
    @Select(value = "SELECT userId FROM User WHERE userId = #{userId}")
    List<Long> SearchUserIdByUserId(@Param("userId") long userId);

    @Select(value = "SELECT userId FROM User WHERE userEmail = #{userEmail}")
    List<Long> SearchUserIdByUserEmail(@Param("userEmail") String userEmail);

    @Select(value = "SELECT userPassword FROM User WHERE userId = #{userId}")
    String SearchUserPasswordByUserId(@Param("userId") long userId);

    @Select(value = "SELECT userId FROM User ORDER BY userId desc LIMIT 1")
    long SearchLastUserId();

}
