package com.pragya.assignment2.utils;

import com.pragya.assignment2.exceptions.MyExceptions;
import com.pragya.assignment2.models.Courses;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidationUtils {

    private static final Pattern GENERIC_NAME_PATTERN = Pattern
            .compile("^([a-zA-Z]+[,.]?[ ]?|[a-zA-Z]+['-]?)+$");

    //To Validate Name
    public static boolean isValidName(String name) throws MyExceptions {
        Matcher matcher = GENERIC_NAME_PATTERN.matcher(name);
        if (!matcher.matches()) {
            throw new MyExceptions("\nInvalid Name.");
        }
        return true;
    }

    //To Validate Address
    public static boolean isValidAddress(String address) throws MyExceptions {
        if (address.length() == 0)
            throw new MyExceptions("\nAddress field is empty.");
        return true;
    }

    //To Validate Age
    public static boolean isValidAge(Integer age) throws MyExceptions {
        try {
            int studentAge = Integer.parseInt(age.toString());
            if (studentAge < 3) {
                throw new MyExceptions("\nAge should be greater than or equal to 3.");
            }
        } catch (MyExceptions e) {
            throw new MyExceptions("\nAge should be Integer! ");
        }
        return true;
    }

    //To Validate Roll Number
    public static boolean isValidRollno(Integer rollno) throws MyExceptions {
        if (rollno == null)
            throw new MyExceptions("\nRoll number field is empty");
        try {
            int studentRollno = Integer.parseInt(rollno.toString());
            if (studentRollno < 3) {
                throw new MyExceptions("\nAge should be greater than or equal to 3.");
            }
        } catch (MyExceptions e) {
            throw new MyExceptions("\nAge should be Integer! ");
        }
        return true;
    }

    //To Validate the Uniqueness of Roll Number
    public static boolean isUniqueRollNo(Integer rollno, Set<Integer> set) throws MyExceptions {
        if (set.contains(rollno)) {
            throw new MyExceptions("Roll Number already exists!");
        } else set.add(rollno);
        return true;
    }

    //To Validate Courses
    public static boolean isValidCourses(List<Courses> list) throws MyExceptions {
        if (list.size() != 4) {
            throw new MyExceptions("It's mandatory to Choose 4 Courses!");
        }
        return true;
    }
}
