package com.pragya.assignment2.handler;

import com.pragya.assignment2.controllers.Action;
import com.pragya.assignment2.exceptions.MyExceptions;
import com.pragya.assignment2.models.Student;

import java.util.*;


public class MenuHandler {

    public static MenuHandler getInstance() {
        return new MenuHandler();
    }

    List<Student> list = new ArrayList<Student>();
    Set<Integer> set = new HashSet<Integer>();

    /**
     * MenuHandler Driven Program
     *
     * @throws MyExceptions
     */
    public void menuDriven() throws MyExceptions {

        Scanner scan = new Scanner(System.in);
        char choice;

        while (true) {
            System.out.println("Student Information Management System ");
            System.out.println("\n1. Add Student's Details ");
            System.out.println("2. Display Student's Details");
            System.out.println("3. Delete Student's Details");
            System.out.println("4. Save Details");
            System.out.println("5. Terminate");

            //User Input his/her Choice
            System.out.println("Choose any one Option: ");
            choice = scan.next().charAt(0);

            //Using Action class Object(Singleton class) to call methods
            switch (choice) {
                case '1': {
                    Action.getInstance().addDetails(list, set);
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
                    Action.getInstance().saveDetails(list);
                    break;
                }
                case '5': {
                    Action.getInstance().terminate();
                    break;
                }

                default: {
                    throw new MyExceptions("Inappropriate Option Choosen!");
                }
            }
        }

    }
}
