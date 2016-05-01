package com.example.sestens.pocket_advisor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import com.example.sestens.pocket_advisor.PHPComm;
import javax.net.ssl.HttpsURLConnection;

/**
 * Created by SabrinaB on 4/13/2016.
 */
public class POST extends PHPComm{

        private int HTTP_Status;
        private String SQL_Message;

        public POST(){
            HTTP_Status = 404;
            SQL_Message = null;
        }

        public POST(String SQL_Message) throws IOException {
            this.SQL_Message = SQL_Message;
            this.HTTP_Status = 404;
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("firstParam", paramValue1));
            params.add(new BasicNameValuePair("secondParam", paramValue2));
            params.add(new BasicNameValuePair("thirdParam", paramValue3));

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getQuery(params));
            writer.flush();
            writer.close();
            os.close();

            conn.connect();
            //ToDo add connection
        }

    private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException
    {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params)
        {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }

        return result.toString();
    }

        public int getHTTP_Status () {
            return this.HTTP_Status;
        }
    }

