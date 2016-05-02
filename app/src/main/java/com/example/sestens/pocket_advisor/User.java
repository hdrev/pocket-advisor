package com.example.sestens.pocket_advisor;


public class User {

    private String userID;
    private String emailAddress;
    private String password;
    private String major;
    private String minor;
    private String name;

    public User(){


    }

    public String getMajor(){
        return major;
    }

    public String getMinor(){
        return minor;
    }

    public String getName(){
        return name;
    }
}
