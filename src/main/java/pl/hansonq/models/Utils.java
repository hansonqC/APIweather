package pl.hansonq.models;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lukasz on 2017-09-23.
 */
public class Utils {
    public static String makeHttpRequest(String url){

        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
            StringBuilder builder = new StringBuilder();
            InputStream inputStream = urlConnection.getInputStream();
            int read = 0;
            while ((read = inputStream.read()) != -1){
                builder.append((char) read);
            }
            return builder.toString();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


/*
    public static String makeHttpsRequest(String url){

        try {
            HttpsURLConnection urlConnection = (HttpsURLConnection) new URL(url).openConnection();
            StringBuilder builder = new StringBuilder();
            int read = 0;
            while ((read = urlConnection.getInputStream().read()) != -1){
                builder.append((char) read);
            }
            System.out.println(builder.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
