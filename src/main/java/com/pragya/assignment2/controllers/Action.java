package com.pragya.assignment2.controllers;

import com.pragya.assignment2.constants.Constants;
import com.pragya.assignment2.exceptions.MyExceptions;
import com.pragya.assignment2.models.Courses;
import com.pragya.assignment2.models.Student;
import com.pragya.assignment2.utils.FileUtils;
import com.pragya.assignment2.utils.ValidationUtils;

import java.util.*;

public class Action {

    public static Action getInstance() {
        return new Action();
    }

    Student student = new Student();
    Scanner sc = new Scanner(System.in);
    List<Student> list1 = new ArrayList<Student>();
    List<Character> character = new ArrayList<Character>();
    String answer, order;
    Integer option;

    /**
     * method to add student's detail into list
     *
     * @param list
     * @param set
     * @throws MyExceptions
     */
    public void addDetails(List<Student> list, Set<Integer> set) throws MyExceptions {
        System.out.println("\nEnter Student's Details: ");

        System.out.println("\nName: ");
        student.setName(sc.nextLine());

        System.out.println("Address: ");
        student.setAddress(sc.nextLine());

        System.out.println("Choose any 4 Courses (A,B,C,D,E,F): ");
        String coursechoosen = sc.nextLine();

        //Store Courses into coursesList from String coursechoosen
        List<Courses> coursesList = new ArrayList<Courses>();
        for (char ch : coursechoosen.toCharArray()) {
            if (ch != ' ') {
                Courses courses = new Courses();
                courses.setCourseName(ch);
                coursesList.add(courses);
            }
        }
        student.addCourse(coursesList);

        System.out.println("Age: ");
        student.setAge(sc.nextInt());

        System.out.println("Roll No: ");
        student.setRollNo(sc.nextInt());

        ValidationUtils.isValidName(student.getName());
        ValidationUtils.isValidAddress(student.getAddress());
        ValidationUtils.isValidAge(student.getAge());
        ValidationUtils.isValidRollno(student.getRollNo());
        ValidationUtils.isUniqueRollNo(student.getRollNo(), set);
        ValidationUtils.isValidCourses(student.getList());

        list.add(student);
        Collections.sort(list);

    }


    /**
     * Method to Display Student's Details according to Order and Option (Input by User)
     *
     * @throws MyExceptions
     */
    public void displayDetails() throws MyExceptions {

        //Choose Ascending or Descending Order
        System.out.println("\nChoose the Order");
        System.out.println("\n1. Ascending Order");
        System.out.println("2. Descending Order");
        System.out.println("\n Enter your Order Choice ");
        order = sc.nextLine();

        //Choose Option for Sorting
        System.out.println("\nChoose the Option");
        System.out.println("\n1. Name");
        System.out.println("2. RollNo");
        System.out.println(("3. Age"));
        System.out.println("4. Address");
        System.out.println("\n Enter your Option Choice ");
        option = sc.nextInt();

        //If User choose Ascending Order
        if (order.equals(Constants.ONE)) {
            FileUtils sf = new FileUtils();
            List<Student> list1 = sf.readFromFile(Constants.FILE_PATH);

            switch (option) {

                //If User want to Sort according to Name
                case 1: {
                    Collections.sort(list1);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-12s",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());

                        for (Courses ct : st.getList()) {

                            System.out.printf("%-2c", ct.getCourseName());
                        }
                        System.out.println("\n");

                    }
                    break;
                }

                //If User want to Sort according to Roll Number
                case 2: {
                    Collections.sort(list1, Student.RollnoComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-12s",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());

                        for (Courses ct : st.getList()) {

                            System.out.printf("%-2c", ct.getCourseName());
                        }
                        System.out.println("\n");

                    }
                    break;
                }

                //If User want to Sort according to Age
                case 3: {
                    Collections.sort(list1, Student.AgeComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-12s",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());

                        for (Courses ct : st.getList()) {

                            System.out.printf("%-2c", ct.getCourseName());
                        }
                        System.out.println("\n");
                    }
                    break;
                }

                //If User want to Sort according to Address
                case 4: {
                    Collections.sort(list1, Student.AddressComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-12s",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());

                        for (Courses ct : st.getList()) {

                            System.out.printf("%-2c", ct.getCourseName());
                        }
                        System.out.println("\n");
                    }
                    break;
                }
                default: {
                    throw new MyExceptions("\nInvalid Option Choosen");
                }
            }
        }

        ////If User choose Descending Order
        else if (order.equals(Constants.TWO)) {
            FileUtils sf = new FileUtils();
            List<Student> list1 = sf.readFromFile(Constants.FILE_PATH);

            switch (option) {

                //If User want to Sort according to Name
                case 1: {
                    Collections.reverse(list1);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-12s",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());

                        for (Courses ct : st.getList()) {

                            System.out.printf("%-2c", ct.getCourseName());
                        }
                        System.out.println("\n");
                    }
                    break;
                }

                //If User want to Sort according to Roll Number
                case 2: {
                    Collections.sort(list1, Student.DesRollnoComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-12s",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());

                        for (Courses ct : st.getList()) {

                            System.out.printf("%-2c", ct.getCourseName());
                        }
                        System.out.println("\n");
                    }
                    break;
                }

                ////If User want to Sort according to Age
                case 3: {
                    Collections.sort(list1, Student.DesAgeComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-12s",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());

                        for (Courses ct : st.getList()) {

                            System.out.printf("%-2c", ct.getCourseName());
                        }
                        System.out.println("\n");
                    }
                    break;
                }

                //If User want to Sort according to Address
                case 4: {
                    Collections.sort(list1, Student.DesAddressComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-12s",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());

                        for (Courses ct : st.getList()) {

                            System.out.printf("%-2c", ct.getCourseName());
                        }
                        System.out.println("\n");
                    }
                    break;
                }
                default: {
                    throw new MyExceptions("\nInvalid Option Choosen");
                }
            }
        }
    }

    /**
     * Method to delete Student's Details according to the corresponding Roll Number (Input from User)
     *
     * @throws MyExceptions
     */
    public void deleteDetails() throws MyExceptions {

        System.out.println("Enter the Roll Number whose Information has to be deleted: ");
        Integer rollNumber = sc.nextInt();
        FileUtils sf = new FileUtils();
        List<Student> list1 = sf.readFromFile(Constants.FILE_PATH);
        int t = -1;
        //To check if Entered Roll Number exists in list or not
        for (int pos = 0; pos < list1.size(); pos++) {
            if (rollNumber.equals(list1.get(pos).getRollNo())) {
                t = pos;
            }
        }

        if (t != -1) {
            list1.remove(t);
        } else {
            System.out.println("\nRoll number entered by the user doesn't exists!");
        }

        System.out.println("Do you want to save the Changes?");
        answer = sc.nextLine();
        if ((Constants.YES).equalsIgnoreCase(answer)) {
            Action.getInstance().saveDetails(list1);
        }
    }

    public void saveDetails(List<Student> list) {
        FileUtils sf = new FileUtils();
        sf.writeToFile(list, Constants.FILE_PATH);
    }

    public void terminate() {
        System.out.println("Do you want to save the changes?");
        answer = sc.nextLine();
        if ((Constants.YES).equalsIgnoreCase(answer)) {
            Action.getInstance().saveDetails(list1);
        } else {
            return;
        }
    }

}