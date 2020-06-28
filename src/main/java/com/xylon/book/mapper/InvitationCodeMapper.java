package com.xylon.book.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface InvitationCodeMapper {

    @Insert(value = "INSERT INTO InvitationCode (invitationCode, isUsed) VALUES (#{invitationCode}, #{isUsed})")
    void AddInvitationCode(InvitationCodeMapper invitationCodeMapper);

    @Select(value = "SELECT isUsed FROM InvitationCode WHERE invitationCode = #{invitationCode}")
    int IsUsed(@Param("invitationCode") int invitationCode);

}
