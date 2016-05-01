package com.example.sestens.pocket_advisor;

/**
 * Created by SabrinaB on 4/11/2016.
 */
public class GET extends PHPComm {

    private int HTTP_Status;
    private String SQL_Message;

    public GET(){
        HTTP_Status = 404;
        SQL_Message = null;
    }

    public GET(String SQL_Message){
        this.SQL_Message = SQL_Message;
        this.HTTP_Status = 404;
        //ToDo add connection
    }

    public int getHTTP_Status () {
        return this.HTTP_Status;
    }
}
