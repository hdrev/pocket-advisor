package com.example.sestens.pocket_advisor;

import java.io.IOException;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.content.Context;

/**
 * Created by SabrinaB on 4/10/2016.
 * Adapted http://developer.android.com/reference/java/net/HttpURLConnection.html
 */
public class PHPComm {

    private String URL;
    private int Conn_Status;
    private HttpURLConnection conn;
    public URL url;
    public PHPComm()
    {
        // Default
        Conn_Status = 404;
        URL = null;
        conn = null;
    }


    public PHPComm(String URL) throws MalformedURLException {
        this.URL = URL;
        URL url = new URL(URL);
        this.url = url;
        HttpURLConnection myURLConnection = null;
        this.conn = myURLConnection;
        try {
            myURLConnection = (HttpURLConnection) url.openConnection();
            Conn_Status = 200;
        } catch (IOException e) {
            Conn_Status = 400;
        }
        try {
            if (myURLConnection != null) {
                myURLConnection.connect();
                Conn_Status = 200;
            }
            else {Conn_Status = 404;}
        } catch (IOException e) {
            Conn_Status = 404;
        }
    }


    public int getConn_Status()
    {
        return this.Conn_Status;
    }

}

