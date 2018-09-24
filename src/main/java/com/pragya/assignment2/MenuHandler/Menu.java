package com.pragya.assignment2.MenuHandler;


import com.pragya.assignment2.Information.Action;
import com.pragya.assignment2.Information.Student;
import java.util.*;
import java.util.Scanner;


public class Menu {

    Menu menu=null;
    public static Menu getInstance()
    {
        return new Menu();
    }

   // List<Student> list = new ArrayList<Student>();

    public void menuDriven() {

        Scanner scan = new Scanner(System.in);

        char choice;

        while(true) {

            System.out.println("Student Information Management System ");
            System.out.println("\n1. Add Student's Details ");
            System.out.println("2. Display Student's Details");
            System.out.println("3. Delete Student's Details");
            System.out.println("4. Save Details");
            System.out.println("5. Terminate");

            System.out.println("Choose any one Option: ");
            choice = scan.next().charAt(0);


            System.out.println("\n");

            switch(choice) {
                case '1': {
                    Action.getInstance().addDetails();
                    break;
                }
                case '2': {
                    Action.getInstance().displayDetails();
                    break;
                }
                case '3': {
                    Action.getInstance().deleteDetails();
                    break;
                }
                case '4': {
                    Action.getInstance().saveDetails();
                    break;
                }
                case '5': {
                    Action.getInstance().terminate();
                    break;
                }

                default: System.out.println("Inappropriate Option Chosen");
            }


        }






    }
}