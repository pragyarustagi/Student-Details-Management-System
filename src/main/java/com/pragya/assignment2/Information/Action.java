package com.pragya.assignment2.Information;

import com.pragya.assignment2.Constants.Constants;
import com.pragya.assignment2.Validations;
import com.pragya.assignment2.exceptions.MyExceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Action {

    public static Action getInstance() {
        return new Action();
    }

    //  List<Student> list = new ArrayList<Student>();
    Student student = new Student();
    Scanner sc = new Scanner(System.in);
    List<Student> list1 = new ArrayList<Student>();
    String answer;
    String order;
    int option;

    String filePath = "/Users/pragyarustagi/pragyaassignment2/src/main/java/com/pragya/assignment2/Information/Store";

    public void addDetails(List<Student> list) throws MyExceptions {
      //  Student student = new Student();
      //  Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student's Details: ");
        System.out.println("\nName: ");
        student.setName(sc.nextLine());
   //     name = sc.nextLine();

        System.out.println("Address: ");
        student.setAddress(sc.nextLine());
   //     address = sc.nextLine();

        System.out.println("Age: ");
        student.setAge(sc.nextInt());
    //    age = sc.nextInt();

        System.out.println("Roll No: ");
        student.setRollNo(sc.nextInt());
    //    rollNo = sc.nextInt();


        //    System.out.println("Courses: ");
        //....

        //   String details = null;
        //   details += s.getName() + " " + s.getRollNo() + " " + s.getAge() + " " + s.getAddress();

//      String filePath = "/Users/pragyarustagi/pragyaassignment2/src/main/java/com/pragya/assignment2/Information/Store";

        Validations valid = new Validations();

        valid.isValidName(student.getName());

        list.add(new Student(student.getName(), student.getRollNo(), student.getAge(), student.getAddress()));
        Collections.sort(list);

        // FileHandler sf = new FileHandler();

       /* sf.writeToFile(list, filePath);
        List<Student> list1 = sf.readFromFile(filePath);
        for (Student st : list1) {
            System.out.printf("%-10s%-7d%-7d%-20s\n",
                    st.getName(), st.getRollNo(), st.getAge(),
                    st.getAddress());

        } */
    }


    public void displayDetails() {

        System.out.println("\nChoose the Order");
        System.out.println("\n1. Ascending Order");
        System.out.println("2. Descending Order");
        System.out.println("\n Enter your Order Choice ");
        order = sc.nextLine();

        System.out.println("\nChoose the Option");
        System.out.println("\n1. Name");
        System.out.println("2. RollNo");
        System.out.println(("3. Age"));
        System.out.println("4. Address");
        System.out.println("\n Enter your Option Choice ");
        option = sc.nextInt();

        if (order.equals(Constants.ONE)) {

            FileHandler sf = new FileHandler();
            List<Student> list1 = sf.readFromFile(filePath);
            switch (option) {
                case 1: {
                    Collections.sort(list1);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-20s\n",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());

                    }
                    break;
                }
                case 2: {
                    Collections.sort(list1, Student.RollnoComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-20s\n",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());

                    }
                    break;
                }
                case 3: {
                    Collections.sort(list1, Student.AgeComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-20s\n",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());

                    }
                    break;
                }
                case 4: {
                    Collections.sort(list1, Student.AddressComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-20s\n",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());

                    }
                    break;
                }
                default:
                    System.out.println("\nInvalid Option Choosen");
                    break;
            }

        } else if (order.equals(Constants.TWO)) {
            FileHandler sf = new FileHandler();
            List<Student> list1 = sf.readFromFile(filePath);
            switch (option) {
                case 1: {
                    Collections.reverse(list1);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-20s\n",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());

                    }
                    break;
                }
                case 2: {
                    Collections.sort(list1, Student.DesRollnoComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-20s\n",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());

                    }
                    break;
                }
                case 3: {
                    Collections.sort(list1, Student.DesAgeComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-20s\n",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());

                    }
                    break;
                }
                case 4: {
                    Collections.sort(list1, Student.DesAddressComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-20s\n",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());

                    }
                    break;
                }
                default:
                    System.out.println("\nInvalid Option Choosen");
                    break;
            }

        }
    }

    public void deleteDetails() throws MyExceptions {

        System.out.println("Enter the Roll Number whose Information has to be deleted: ");
        Scanner scan = new Scanner(System.in);
        Integer rollNumber = scan.nextInt();
        FileHandler sf = new FileHandler();
        List<Student> list1 = sf.readFromFile(filePath);
     //   Integer RnoPresent = 0;
        int t = -1;
        //  List<Student> found = new ArrayList<Student>();
        for (int pos = 0; pos < list1.size(); pos++) {
            if (rollNumber.equals(list1.get(pos).getRollNo())) {
                t = pos;
                //       found.add(st);
            }
        }

        if (t != -1) {
            list1.remove(t);
        }
        else {
            throw new MyExceptions("Roll number entered by the user doesn't exists!");
        }

        System.out.println("Do you want to save the Changes?");
        answer = sc.nextLine();
        if((Constants.YES).equalsIgnoreCase(answer)) {
            Action.getInstance().saveDetails(list1);
        }


    /*    if (RnoPresent == 0) {
            System.out.println("Rollno entered by the user doesn't exists!");
        } else {
            list1.removeAll(found);
        } */

      //  sf.writeToFile(list1, filePath);
     /*   List<Student> li = sf.readFromFile(filePath);
        for (Student st : li) {
            System.out.printf("%-10s%-7d%-7d%-20s\n",
                    st.getName(), st.getRollNo(), st.getAge(),
                    st.getAddress());
        } */
    }


    public void saveDetails(List<Student> list) {
        FileHandler sf = new FileHandler();
        sf.writeToFile(list, filePath);
        /*  List<Student> li = sf.readFromFile(filePath);
            for (Student st : li) {
                System.out.printf("%-10s%-7d%-7d%-20s\n",
                        st.getName(), st.getRollNo(), st.getAge(),
                        st.getAddress());
            } */
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