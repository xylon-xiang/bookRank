package com.xylon.book.model;


public class User {

    private long userId;

    private String userEmail;

    private String userName;

    private String userPassword;

    private int invitationCode;


    public void setUserId(long userId){
        this.userId = userId;
    }
    public long getUserId(){
        return userId;
    }


    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }
    public String getUserEmail(){
        return userEmail;
    }


    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }


    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }
    public String getUserPassword(){
        return userPassword;
    }


    public void setInvitationCode(int invitationCode) { this.invitationCode = invitationCode; }
    public int getInvitationCode(){
        return invitationCode;
    }
}
