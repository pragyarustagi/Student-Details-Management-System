package com.pragya.assignment2;

import com.pragya.assignment2.exceptions.MyExceptions;
import com.pragya.assignment2.handler.MenuHandler;

public class Main {
    public static void main(String args[]) throws MyExceptions {
        MenuHandler.getInstance().menuDriven();
    }
}
