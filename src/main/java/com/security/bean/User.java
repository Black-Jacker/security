package com.security.bean;


import java.io.Serializable;

public class User implements Serializable{

    private String id;
    private String nickname;
    private String email;
    private String passwd;
    private String phoneno;
    private String head_pic;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getHead_pic() {
        return head_pic;
    }

    public void setHead_pic(String head_pic) {
        this.head_pic = head_pic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
//    public User(){}
//
//    public User(String id, String email,String name,String password,String phone){
//        this.id = id;
//        this.email =email;
//        this.name = name;
//        this.password = password;
//        this.phone = phone;
//    }


}
