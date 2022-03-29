package com.randomhouse.bookstore.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateUtils {

    private DateUtils(){}

    public static final String DD_MM_YYYY = "dd-MM-yyyy";

    public static String compareDates(String date1, String date2) {
        var sdf = new SimpleDateFormat(DD_MM_YYYY);
        String mostRecentDate = date1;
        try{
            Date first = sdf.parse(date1);
            Date secound = sdf.parse(date2);
            if(first.compareTo(secound)<0){
             mostRecentDate= date2;
            }
        }
        catch (ParseException ex){
            log.error("Parsing exception {}",ex.getMessage());
        }

        return mostRecentDate;

    }

}
