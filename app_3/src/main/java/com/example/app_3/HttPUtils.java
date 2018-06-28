package com.example.app_3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * Created by Misaya on 2018/6/27.
 */

public class HttPUtils {
    public static String getString(String path){
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if (conn.getResponseCode()==200) {
                InputStream inputStream = conn.getInputStream();
                int len = 0 ;
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[]bytes = new byte[1024];
                while ((len = inputStream.read(bytes))!=-1){
                    outputStream.write(bytes,0,len);
                }
                return  outputStream.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
