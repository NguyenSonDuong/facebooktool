package com.kit502.facebook.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.stream.Collectors;

public class HelpService {

    public static String getResourceFileAsString(String fileName) {
        InputStream is = getResourceFileAsInputStream(fileName);
        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            return (String)reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } else {
            throw new RuntimeException("resource not found");
        }
    }

    public static void Logger(String key,String message){
        System.out.println( new Date().toGMTString() + " : " + key + " : " + message);
    }

    public static InputStream getResourceFileAsInputStream(String fileName) {
        ClassLoader classLoader = HelpService.class.getClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }
}
