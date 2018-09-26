package com.pragya.assignment2;

import com.pragya.assignment2.exceptions.MyExceptions;
import com.pragya.assignment2.utils.ValidationUtils;
import org.junit.Assert;
import java.util.*;
import org.junit.Test;


import java.util.HashSet;
import java.util.Set;

public class ValidationsTest {

    @Test(expected = MyExceptions.class)
    public void testValidName1() throws MyExceptions {
        ValidationUtils.isValidName("123");
    }

    @Test
    public void testValidName2() throws MyExceptions {
        Assert.assertTrue(ValidationUtils.isValidName("Gaurav"));
    }

    @Test(expected = MyExceptions.class)
    public void testValidAge1() throws MyExceptions {
        ValidationUtils.isValidAge(2);
    }

    @Test(expected = MyExceptions.class)
    public void testValidAge2() throws MyExceptions {
        ValidationUtils.isValidAge(-45);
    }

    @Test
    public void testValidAge3() throws MyExceptions {
        Assert.assertTrue(ValidationUtils.isValidAge(6));
    }

    @Test(expected = MyExceptions.class)
    public void testValidAddress1() throws MyExceptions {
        ValidationUtils.isValidAddress("");
    }

    @Test
    public void testValidAddress2() throws MyExceptions {
        Assert.assertTrue(ValidationUtils.isValidAddress("B-44/S-1,Delhi"));
    }

    @Test(expected = MyExceptions.class)
    public void testValidRollNo1() throws MyExceptions {
        ValidationUtils.isValidRollno(-4);
    }

    @Test
    public void testValidRollNo2() throws MyExceptions {
        Assert.assertTrue(ValidationUtils.isValidRollno(4));
    }

}
