package com.example.aiimsproject.Utils;

import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import static com.example.aiimsproject.Constant.ValidationConstant.EMAIL_VALIDATION_REGEX;
import static com.example.aiimsproject.Constant.ValidationConstant.NUMBER_FORMAT;
import static com.example.aiimsproject.Constant.ValidationConstant.PHONE_VALIDATION_REGEX;

public class ValidationUtil {

    public static boolean validateEmail(String emailID) {

        Pattern pattern = Pattern.compile(EMAIL_VALIDATION_REGEX);

        return pattern.matcher(emailID).matches();

    }


    public static boolean validateMobile(String phone) {

        if (!Pattern.matches(PHONE_VALIDATION_REGEX, phone)) {
            if (phone.length() < 10 || phone.length() > 13) {
                // if(phone.length() != 10) {
                return false;

            } else {
                return true;
            }
        } else {
            return false;
        }


    }


    public static   boolean validateName(String name,int min) {

        if (name.length() < min) {
            // if(phone.length() != 10) {
            return false;

        } else {
            return true;
        }

    }

    public static long DateToLong(String date){
        long milliseconds= 0;
        SimpleDateFormat f = new SimpleDateFormat("d/M/yyyy");
        try {
            Date d = f.parse(date);
            milliseconds = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return milliseconds;
    }


    public static  String longToDate(long date) {

        // or you already have long value of date, use this instead of milliseconds variable.
        return DateFormat.format("dd-MM-yyyy", new Date(date)).toString();
    }

    public static  String removeExtraSpace(String string){
        return  string.replaceAll("\\s+", " ");
    }


    public static String stringFormatIn2Digit(int value) {
        return String.format(NUMBER_FORMAT, value);
    }



}
