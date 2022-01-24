package com.project.core.utils;


import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class JSONLoaders {
   // private static final String USER_AGENT = "Mozilla/5.0";
    public static String readJson(String url) {
        StringBuffer output = new StringBuffer();
        try{
            URL url1 = new URL(url);
            Scanner scanner = new Scanner(url1.openStream());
            //BufferedReader br = new BufferedReader(new InputStreamReader(url1.openStream()));
            String line = "";
            while(scanner.hasNextLine()){
                line = scanner.nextLine();
                output.append(line);
            }
            return output.toString();
        }catch (MalformedURLException malformedURLException){

        }catch (IOException ioException){

        }
        return "There was no data found";
    }
}