package com.pragya.assignment2;

import com.pragya.assignment2.exceptions.MyExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validations {
    static int x=0;

    private static final Pattern GENERIC_NAME_PATTERN = Pattern
            .compile("^([a-zA-Z]+[,.]?[ ]?|[a-zA-Z]+['-]?)+$");


    public static boolean isValidName(String name) throws MyExceptions {
        Matcher matcher = GENERIC_NAME_PATTERN.matcher(name);
        if(!matcher.matches())
            throw new MyExceptions("\nInvalid Name");
        return true;
    }

    public static boolean isValidAddress(String address) throws MyExceptions {
        if(address.length() == 0)
            throw new MyExceptions("\nAddress field is empty");
        return true;
    }

    public static boolean isValidAge(Integer age) throws MyExceptions {
        if(age == null)
            throw new MyExceptions("\nAge field is empty");
        return true;

    }

    public static boolean isValidRollno(Integer rollno) throws MyExceptions {
        if(rollno == null)
            throw new MyExceptions("\nRollno field is empty");
        return true;

    }


}
